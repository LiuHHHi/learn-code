package com.yunzainfo.code2.service;

import com.yunzainfo.code2.table.TableAccount;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/19 18:47
 */
public interface AccountService {

    /**
     * 创建账号
     *
     * @param account
     * @param passwordText
     * @return
     */
    TableAccount saveAccount(String account, String passwordText);

    /**
     * 修改密码
     *
     * @param account
     * @param oldPasswordText
     * @param newPasswordText
     * @return
     */
    TableAccount updatePassword(String account, String oldPasswordText, String newPasswordText);

    /**
     * 修改账户锁定状态
     *
     * @param account
     * @param lock
     * @return
     */
    TableAccount changeAccountLock(String account, Integer lock);

    /**
     * 删除账户
     *
     * @param account
     */
    void removeAccount(String account);

    /**
     * 查询账号是否存在
     * 判断账号是否锁定
     * 判断密码是否匹配
     *
     * @param account
     * @param passwordMd5
     * @return
     */
    boolean validatedPasswordByAccount(String account, String passwordMd5);

    /**
     * 查询全部账号列表
     *
     * @return
     */
    List<TableAccount> listAccountAll();

    /**
     * 分页查询
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<TableAccount> listAccountByPage(Integer pageIndex, Integer pageSize);
}
