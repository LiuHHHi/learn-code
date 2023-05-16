package com.yunzainfo.code4.mapper;

import com.yunzainfo.code4.table.TableAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/27 11:11
 */
@Mapper
public interface AccountMapper {
    List<TableAccount> findAll();
}
