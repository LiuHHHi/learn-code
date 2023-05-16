package com.yunzainfo.code2.entity.param;

import lombok.Data;

/**
 * @author Lemon
 * @date 2022/5/19 19:49
 */
@Data
public class AccountParam {
    private String account;
    private String passwordText;
    private String newPasswordText;
}
