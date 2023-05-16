package com.yunzainfo.code3.entity;

import com.yunzainfo.code3.table.TableAccountDetail;
import lombok.Data;

/**
 * @author Lemon
 * @date 2022/5/24 20:27
 */
@Data
public class AssociationAccount {
    private String id;
    private String account;
    private String passwordMd5;

    private TableAccountDetail accountDetail;
}
