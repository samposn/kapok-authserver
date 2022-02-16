package com.kapokframework.authserver.client.service;

import com.kapokframework.authserver.client.model.ClientDetailsEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetailsService;

import java.util.List;

/**
 * @author Will WM. Zhang
 * @since 2020-03-25 00:02
 */
public interface ClientDetailsEntityService extends ClientDetailsService {

    @Override
    ClientDetailsEntity loadClientByClientId(String clientId) throws OAuth2Exception;

    ClientDetailsEntity create(ClientDetailsEntity clientDetailsEntity);

    ClientDetailsEntity retrieve(String clientId);

    ClientDetailsEntity updateClient(ClientDetailsEntity oldClient, ClientDetailsEntity newClient);

    void delete(ClientDetailsEntity clientDetailsEntity);

    void recycle(ClientDetailsEntity clientDetailsEntity);

    List<ClientDetailsEntity> list();

    ClientDetailsEntity generateClientId(ClientDetailsEntity clientDetailsEntity);

    ClientDetailsEntity generateClientSecret(ClientDetailsEntity clientDetailsEntity);

}
