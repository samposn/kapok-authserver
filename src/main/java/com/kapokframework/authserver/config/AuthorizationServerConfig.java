package com.kapokframework.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

/**
 * 授权服务
 *
 * @author Will WM. Zhang
 * @since 2019-09-06 09:51
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final TokenStore tokenStore;

    private final DataSource dataSource;

    private final AuthenticationManager authenticationManager;

    private final ClientDetailsService clientDetailsService;

    @Autowired
    public AuthorizationServerConfig(TokenStore tokenStore,
                                     DataSource dataSource,
                                     ClientDetailsService clientDetailsService,
                                     AuthenticationManager authenticationManager) {
        this.tokenStore = tokenStore;
        this.dataSource = dataSource;
        this.clientDetailsService = clientDetailsService;
        this.authenticationManager = authenticationManager;
    }

    // 配置客户端详情服务
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource);
    }

    // 配置令牌（token）的访问端点和令牌服务（token services）
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints
            .authenticationManager(authenticationManager) // 认证管理器
            .authorizationCodeServices(this.authorizationCodeServices()) // 授权码服务
            .tokenServices(this.tokenServices()) // 令牌管理服务
            .allowedTokenEndpointRequestMethods(HttpMethod.POST)
        ;
    }

    // 配置令牌端点的安全约束
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
            .tokenKeyAccess("permitAll()") // 公开oauth/token_key
            .checkTokenAccess("permitAll()") // 公开oauth/check_token
            .allowFormAuthenticationForClients() // 表单认证（申请令牌）
        ;
    }

    // 配置客户端注册服务
    @Bean
    public ClientRegistrationService clientRegistrationService(DataSource dataSource) {
        return new JdbcClientDetailsService(dataSource);
    }

    // 配置令牌服务
    private AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setAccessTokenValiditySeconds(7200); // 令牌默认有效期2小时
        tokenServices.setRefreshTokenValiditySeconds(259200);// 刷新令牌默认有效期3天
        return tokenServices;
    }

    // 设置授权码模式的授权码如何存取，暂采用内存方式
    private AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }
}
