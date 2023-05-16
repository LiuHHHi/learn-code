package com.yunzainfo.code3.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/24 20:57
 */
@Data
public class CollectionAccount {
    private String id;
    private String account;
    private String passwordMd5;

    private List<String> roles;
}
