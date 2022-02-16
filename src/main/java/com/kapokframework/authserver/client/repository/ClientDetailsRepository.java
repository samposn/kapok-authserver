package com.kapokframework.authserver.client.repository;

import com.kapokframework.authserver.client.model.ClientDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Will WM. Zhang
 * @since 2020-03-25 00:45
 */
@Repository
public interface ClientDetailsRepository extends JpaRepository<ClientDetailsEntity, String> {
}
