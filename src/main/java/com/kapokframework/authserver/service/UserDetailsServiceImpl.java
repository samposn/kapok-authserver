package com.kapokframework.authserver.service;

import com.kapokframework.authserver.account.model.Account;
import com.kapokframework.authserver.account.repository.AccountRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Will WM. Zhang
 * @since 2020-03-11 10:40
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    public UserDetailsServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 需要配置权限
        Account account = accountRepository.findAccountByUsername(username);
        if (account != null) {
            String password = account.getPassword();
            return User.withUsername(username).password(password).authorities("all").build();
        }
        return null;
    }

}
