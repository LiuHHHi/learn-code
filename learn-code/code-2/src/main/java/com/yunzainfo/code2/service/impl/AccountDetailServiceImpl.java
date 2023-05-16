package com.yunzainfo.code2.service.impl;

import com.yunzainfo.code2.entity.param.AccountDetailParam;
import com.yunzainfo.code2.repository.AccountDetailRepository;
import com.yunzainfo.code2.service.AccountDetailService;
import com.yunzainfo.code2.table.TableAccount;
import com.yunzainfo.code2.table.TableAccountDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(rollbackFor = Exception.class)
public class AccountDetailServiceImpl implements AccountDetailService {

    private final AccountDetailRepository accountDetailRepository;

    public AccountDetailServiceImpl(AccountDetailRepository accountDetailRepository) {
        this.accountDetailRepository = accountDetailRepository;
    }

    @Override
    public TableAccountDetail saveAccountDetail(AccountDetailParam accountDetail) {
        TableAccountDetail t=accountDetailRepository.findAllByAccount(accountDetail.getAccount());
        if (t==null){
            return null;
        }
        TableAccountDetail tableAccountDetail=new TableAccountDetail();
        tableAccountDetail.setAccount(accountDetail.getAccount());
        tableAccountDetail.setName(accountDetail.getName());
        tableAccountDetail.setSex(accountDetail.getSex());
        tableAccountDetail.setAge(accountDetail.getAge());
        tableAccountDetail.setNumKind(accountDetail.getNumKind());
        tableAccountDetail.setNumber(accountDetail.getNumber());
        tableAccountDetail.setPhone(accountDetail.getPhone());
        accountDetailRepository.save(tableAccountDetail);
        return tableAccountDetail;
    }

    @Override
    public List<TableAccountDetail> listAccountDetailAll() {
        return accountDetailRepository.findAll();
    }

    @Override
    public TableAccountDetail updatePhone(String account, Integer newPhone) {
        TableAccountDetail tableAccountDetail=accountDetailRepository.findAllByAccount(account);
        tableAccountDetail.setPhone(newPhone);
        accountDetailRepository.save(tableAccountDetail);
        return tableAccountDetail;
    }

    @Override
    public void removeAccountDetail(String account) {
        accountDetailRepository.deleteAllByAccount(account);
    }

    @Override
    public List<TableAccountDetail> listAccountDetailByPage(Integer pageIndex, Integer pageSize) {
        Sort sort = Sort.by(Sort.Direction.DESC, "gmtModified");
        PageRequest pageRequest = PageRequest.of(pageIndex, pageSize, sort);
        Page<TableAccountDetail> all =accountDetailRepository.findAll(pageRequest);
        return all.getContent();
    }
}
