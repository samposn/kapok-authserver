package com.kapokframework.authserver.account.service;

import com.kapokframework.authserver.account.model.Account;

import java.util.List;
import java.util.Map;

/**
 * @author Will WM. Zhang
 * @since 2020-03-12 13:50
 */
public interface AccountService {

    Account create(Account account);

    Account retrieve(Long id);

    Account update(Long id, Map<String, Object> values);

    String delete(Long id);

    String recycle(Long id);

    List<Account> list();

}
