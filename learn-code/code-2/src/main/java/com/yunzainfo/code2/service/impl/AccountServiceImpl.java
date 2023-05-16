package com.yunzainfo.code2.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.yunzainfo.code2.repository.AccountDetailRepository;
import com.yunzainfo.code2.repository.AccountRepository;
import com.yunzainfo.code2.service.AccountDetailService;
import com.yunzainfo.code2.service.AccountService;
import com.yunzainfo.code2.table.TableAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/19 18:57
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    private AccountDetailService accountDetailService;
    @Autowired
    private AccountDetailRepository accountDetailRepository;

    @Override
    public TableAccount saveAccount(String account, String passwordText) {
        Date now = new Date(System.currentTimeMillis());
        // 保存一个数据，必须 new 一个数据库的类
        // 注意：保存的时候没有设置 主键 。没有设置主键的情况下，才会新加一条数据
        TableAccount tableAccount = new TableAccount();
        tableAccount.setGmtCreate(now);
        tableAccount.setGmtModified(now);
        tableAccount.setAccount(account);
        String passwordMd5 = SecureUtil.md5(passwordText);
        tableAccount.setPassword(passwordMd5);
        tableAccount.setFlagLock(0);
        accountRepository.save(tableAccount);
        return tableAccount;
    }

    @Override
    public TableAccount updatePassword(String account, String oldPasswordText, String newPasswordText) {
        TableAccount tableAccount = accountRepository.findByAccount(account);
        if (tableAccount == null) {
            throw new RuntimeException("账号不存在");
        }
        String oldPasswordMd5 = SecureUtil.md5(oldPasswordText);
        if (!oldPasswordMd5.equals(tableAccount.getPassword())) {
            throw new RuntimeException("旧密码不正确");
        }
        String newPasswordMd5 = SecureUtil.md5(newPasswordText);
        tableAccount.setPassword(newPasswordMd5);
        accountRepository.save(tableAccount);
        return tableAccount;
    }

    @Override
    public TableAccount changeAccountLock(String account, Integer lock) {
        TableAccount tableAccount = accountRepository.findByAccount(account);
        if (tableAccount == null) {
            throw new RuntimeException("账号不存在");
        }
        if (lock == null) {
            lock = 0;
        }
        tableAccount.setFlagLock(lock);
        accountRepository.save(tableAccount);
        return tableAccount;
    }

    @Override
    public void removeAccount(String account) {
        if (accountDetailRepository.findAllByAccount(account)!=null){
            accountDetailService.removeAccountDetail(account);
        }
        accountRepository.deleteByAccount(account);

    }

    @Override
    public boolean validatedPasswordByAccount(String account, String passwordMd5) {
        TableAccount tableAccount = accountRepository.findByAccount(account);
        if (tableAccount == null) {
            return false;
        }
        return passwordMd5.equals(tableAccount.getPassword());
    }

    @Override
    public List<TableAccount> listAccountAll() {
        return accountRepository.findAll();
    }

    @Override
    public List<TableAccount> listAccountByPage(Integer pageIndex, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "gmtModified");
        // 参数 page [0, ∞) size: [1,∞)
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<TableAccount> all = accountRepository.findAll(pageRequest);
        return all.getContent();
    }
}
