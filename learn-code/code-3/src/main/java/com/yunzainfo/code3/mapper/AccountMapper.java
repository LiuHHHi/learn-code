package com.yunzainfo.code3.mapper;

import com.yunzainfo.code3.entity.AssociationAccount;
import com.yunzainfo.code3.entity.CollectionAccount;
import com.yunzainfo.code3.entity.ShortAccount;
import com.yunzainfo.code3.table.TableAccount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/24 11:56
 */
@Mapper
public interface AccountMapper {
    List<TableAccount> findTableAccountAll();
    TableAccount findAccountByAccount(@Param("account") String account);
    int updateTableAccountByAccount(@Param("t") TableAccount tableAccount);
    int insertTableAccount(@Param("t") TableAccount tableAccount);
    int insertTableAccount1(@Param("t") TableAccount tableAccount);
    int insertTableAccount2(@Param("t") TableAccount tableAccount);
    int insertTableAccount3(@Param("account") String account,
                            @Param("password") String password,
                            @Param("flagLock") String flagLock);
    List<TableAccount> findTableAccountInAccounts(@Param("accounts") List<String> accounts);
    List<TableAccount> findTableAccountQuery(@Param("t") TableAccount tableAccount);

    ShortAccount findShortAccountByAccount(@Param("account") String account);
    ShortAccount findShortAccountByAccount1(@Param("account") String account);

    AssociationAccount findAssociationAccountByAccount(@Param("account") String account);
    CollectionAccount findCollectionAccountByAccount(@Param("account") String account);

    AssociationAccount findAssociationAccountByAccount1(@Param("account") String account);
    CollectionAccount findCollectionAccountByAccount1(@Param("account") String account);
}
