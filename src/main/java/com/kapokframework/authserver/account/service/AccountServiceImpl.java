package com.kapokframework.authserver.account.service;

import com.kapokframework.authserver.account.model.Account;
import com.kapokframework.authserver.account.repository.AccountRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author Will WM. Zhang
 * @since 2020-03-12 13:51
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * 创建
     * <p>
     * 级联保存的过程：先insert一方，再insert多方，然后返回数据（关联字段还没有值），再update多方的关联字段
     *
     * @param account 将要创建的账号数据
     * @return 返回创建成功的账号数据
     */
    @Override
    @Transactional
    public Account create(Account account) {
        return this.accountRepository.save(account);
    }

    /**
     * 获取
     *
     * @param id 根据 id 获取账号数据
     * @return 返回获取到的账号数据
     */
    @Override
    public Account retrieve(Long id) {
        // TODO 异常处理
        return this.accountRepository.findById(id).orElse(null);
    }

    /**
     * 更新
     */
    @Override
    @Transactional
    public Account update(Long id, Map<String, Object> values) {
        // TODO 异常处理
        Optional<Account> optById = this.accountRepository.findById(id);
        if (optById.isPresent()) {
            Account dbAccount = optById.get();
            for (String key : values.keySet()){
                try {
                    BeanUtils.setProperty(dbAccount, key, values.get(key));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            return dbAccount;
        }
        return null;
    }

    /**
     * 删除
     */
    @Transactional
    @Override
    public String delete(Long id) {
        this.accountRepository.deleteById(id);
        return "{\"Status\":\"OK\"}";
    }

    /**
     * 回收
     */
    @Transactional
    @Override
    public String recycle(Long id) {
        return null;
    }

    /**
     * 搜索
     *
     * @return
     */
    @Override
    public List<Account> list() {
        return this.accountRepository.findAll();
    }

}
