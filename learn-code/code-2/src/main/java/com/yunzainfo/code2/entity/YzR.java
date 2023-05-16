package com.yunzainfo.code2.entity;

import org.springframework.http.ResponseEntity;

/**
 * @author Lemon
 * @date 2022/5/18 16:59
 */
public final class YzR {
    /**
     * 正常结果
     *
     * @param data 数据
     * @param <T>  返回值
     * @return
     */
    public static <T> ResponseEntity<ResultEntity<T>> ofOk(T data) {
        ResultEntity<T> ok = new ResultEntity<>(true, "ok", data);
        return ResponseEntity.ok(ok);
    }
}
