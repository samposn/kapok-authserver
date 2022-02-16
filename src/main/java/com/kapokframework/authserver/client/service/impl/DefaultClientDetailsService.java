package com.kapokframework.authserver.client.service.impl;

import com.kapokframework.authserver.client.model.ClientDetailsEntity;
import com.kapokframework.authserver.client.repository.ClientDetailsRepository;
import com.kapokframework.authserver.client.service.ClientDetailsEntityService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.UUID;

/**
 * @author Will WM. Zhang
 * @since 2020-03-20 15:49
 */
// TODO 应该把注册服务与验证的 loadClientByClientId 分开
@Service
public class DefaultClientDetailsService implements ClientDetailsEntityService {

    private final ClientDetailsRepository clientDetailsRepository;

    public DefaultClientDetailsService(ClientDetailsRepository clientDetailsRepository) {
        this.clientDetailsRepository = clientDetailsRepository;
    }

    @Override
    public ClientDetailsEntity loadClientByClientId(String clientId) throws OAuth2Exception {
        return this.clientDetailsRepository.getOne(clientId);
    }

    @Override
    public ClientDetailsEntity create(ClientDetailsEntity clientDetailsEntity) {
        return this.clientDetailsRepository.save(clientDetailsEntity);
    }

    @Override
    public ClientDetailsEntity retrieve(String clientId) {
        // TODO 异常处理
        return this.clientDetailsRepository.findById(clientId).orElse(null);
    }

    @Override
    public ClientDetailsEntity updateClient(ClientDetailsEntity oldClient, ClientDetailsEntity newClient) {
        // TODO
        return null;
    }

    @Override
    public void delete(ClientDetailsEntity clientDetailsEntity) {
        this.clientDetailsRepository.delete(clientDetailsEntity);
    }

    @Override
    public void recycle(ClientDetailsEntity clientDetailsEntity) {
        // TODO
    }

    @Override
    public List<ClientDetailsEntity> list() {
        return this.clientDetailsRepository.findAll();
    }

    // TODO 是否需要改方式
    @Override
    public ClientDetailsEntity generateClientId(ClientDetailsEntity clientDetailsEntity) {
        clientDetailsEntity.setClientId(UUID.randomUUID().toString());
        return clientDetailsEntity;
    }

    // TODO 是否需要改方式
    @Override
    public ClientDetailsEntity generateClientSecret(ClientDetailsEntity clientDetailsEntity) {
        clientDetailsEntity.setClientSecret(Base64.encodeBase64URLSafeString(new BigInteger(512, new SecureRandom()).toByteArray()).replace("=", ""));
        return clientDetailsEntity;
    }
}
