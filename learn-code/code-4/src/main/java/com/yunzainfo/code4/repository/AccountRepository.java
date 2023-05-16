package com.yunzainfo.code4.repository;

import com.yunzainfo.code4.table.TableAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/19 18:39
 */
@Repository
public interface AccountRepository extends JpaRepository<TableAccount, String>, JpaSpecificationExecutor<TableAccount> {
    /**
     * 由于 account 在表中设置了唯一键
     * 所以这里用 单独的类接收
     *
     * @param account
     * @return
     */
    TableAccount findByAccount(String account);

    /**
     * 由于通过 该字段查询 返回的值有可能出现2个以上
     * 所以用List来接收值
     *
     * @param flagLock
     * @return
     */
    List<TableAccount> findByFlagLock(Integer flagLock);

    /**
     * 通过2个参数查询
     *
     * @param account
     * @param password
     * @return
     */
    TableAccount findByAccountAndPassword(String account, String password);


    void deleteByAccount(String account);
}
