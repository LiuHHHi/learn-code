package com.yunzainfo.code3.entity;

import lombok.Data;

/**
 * @author Lemon
 * @date 2022/5/24 20:00
 */
@Data
public class ShortAccount {
    private String id;
    private String account;
    private String passwordMd5;
}
