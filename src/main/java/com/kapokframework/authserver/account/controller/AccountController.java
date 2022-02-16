package com.kapokframework.authserver.account.controller;

import com.kapokframework.authserver.account.model.Account;
import com.kapokframework.authserver.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Will WM. Zhang
 * @since 2019-09-06 10:52
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 创建
     *
     * @param account 将要创建的账号数据
     * @return 返回创建成功的账号数据
     */
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@RequestBody Account account) {
        return this.accountService.create(account);
    }

    /**
     * 获取
     *
     * @param id 根据 id 获取账号数据
     * @return 返回获取到的账号数据
     */
    @GetMapping("/{id}")
    @ResponseBody
    public Account retrieve(@PathVariable("id") Long id) {
        return this.accountService.retrieve(id);
    }

    /**
     * 更新
     *
     * @param id
     * @param values
     * @return
     */
    @PutMapping("/{id}")
    public Account update(@PathVariable("id") Long id, @RequestBody Map<String, Object> values) {
        return this.accountService.update(id, values);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        return this.accountService.delete(id);
    }

    /**
     * 回收
     *
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}", headers = {"Action=recycle"})
    public String recycle(@PathVariable("id") Long id) {
        return this.accountService.recycle(id);
    }

    /**
     * 搜索
     *
     * @return
     */
    @GetMapping
    @ResponseBody
    public List<Account> list() {
        return this.accountService.list();
    }
}
