package com.yunzainfo.code2.service;

import com.yunzainfo.code2.entity.param.AccountDetailParam;
import com.yunzainfo.code2.table.TableAccount;
import com.yunzainfo.code2.table.TableAccountDetail;

import java.util.List;


public interface AccountDetailService {
    TableAccountDetail saveAccountDetail(AccountDetailParam accountDetail);

    List<TableAccountDetail> listAccountDetailAll();

    TableAccountDetail updatePhone(String account,Integer newPhone);

    void removeAccountDetail(String account);

    List<TableAccountDetail> listAccountDetailByPage(Integer pageIndex, Integer pageSize);
}
