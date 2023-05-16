package com.yunzainfo.code4.service;

import com.yunzainfo.code4.table.TableAccount;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/27 13:52
 */
public interface Code4Service {
    List<TableAccount> mybatisPage(Integer pageIndex, Integer pageSize);

    List<TableAccount> jpaSpecification(String account, String password);
}
