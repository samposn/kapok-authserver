package com.kapokframework.authserver.account.repository;

import com.kapokframework.authserver.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Will WM. Zhang
 * @since 2020-03-12 14:39
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByUsername(String username);

}