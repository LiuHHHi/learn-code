package com.yunzainfo.code4.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wenhao.jpa.Specifications;
import com.yunzainfo.code4.mapper.AccountMapper;
import com.yunzainfo.code4.repository.AccountRepository;
import com.yunzainfo.code4.service.Code4Service;
import com.yunzainfo.code4.table.TableAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/27 13:53
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class Code4ServiceImpl implements Code4Service {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public Code4ServiceImpl(AccountMapper accountMapper,
                            AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<TableAccount> mybatisPage(Integer pageIndex, Integer pageSize) {
        log.info("输入参数： pageIndex = {}, pageSize = {}", pageIndex, pageSize);

        PageHelper.clearPage();
        // todo ?? startPage 边界值，pageNum 是从 0 开始还是 1开始，pageSize  是从 0 开始还是 1开始
        PageHelper.startPage(pageIndex, pageSize);
        List<TableAccount> tableAccountList = accountMapper.findAll();
        PageInfo<TableAccount> pageInfo = PageInfo.of(tableAccountList);
        log.info("查询结果信息：PageInfo = {}", pageInfo);

        return tableAccountList;
    }

    @Override
    public List<TableAccount> jpaSpecification(String account, String password) {
        // https://www.w3cschool.cn/jpaspec/j19z1s3u.html
        // and 链接符号 是 and
        Specification<TableAccount> specificationAnd = Specifications.<TableAccount>and()
                // eq ： where account = #{account}
                .eq("account", account)
                // if (StringUtils.hasText(password)) {  where password = #{password} }
                .eq(StringUtils.hasText(password), "password", password)
                //.ne(StringUtils.hasText(password), "password", password)
                //.in("account", "101", "102")
                //.notIn("account", "101", "102")
                .build();

        Specification<TableAccount> specificationOr = Specifications.<TableAccount>or()
                .build();

        List<TableAccount> tableAccountList = accountRepository.findAll(specificationAnd);
        return tableAccountList;
    }
}
