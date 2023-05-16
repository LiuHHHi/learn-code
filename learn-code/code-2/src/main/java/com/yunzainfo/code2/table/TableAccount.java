package com.yunzainfo.code2.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Lemon
 * @date 2022/5/19 18:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account", schema = "info")
@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
public class TableAccount {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    @Column(name = "gmt_create", nullable = false)
    private Date gmtCreate;
    @Column(name = "gmt_modified", nullable = false)
    private Date gmtModified;
    /**
     * 设置数据库字段不能为空，内容值唯一
     */
    @Column(name = "account", nullable = false, unique = true)
    private String account;
    /**
     * 密码加密规则:  md5(password)
     */
    @Column(name = "password")
    private String password;
    /**
     * 0: 默认，1：锁定
     */
    @Column(name = "flag_lock")
    private Integer flagLock;
}
