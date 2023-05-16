package com.yunzainfo.code1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Lemon
 * @date 2022/5/18 17:00
 */
@Data
@AllArgsConstructor
public class ResultEntity<T> {
    private Boolean status;
    private String msg;
    private T data;
}
