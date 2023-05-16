package com.yunzainfo.code3;

import com.yunzainfo.code3.mapper.AccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Code3ApplicationTests {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void findTableAccountAll(){
        System.out.println(accountMapper.findAccountByAccount("1004"));
    }

}
