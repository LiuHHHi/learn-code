package com.yunzainfo.code3.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Lemon
 * @date 2022/5/19 18:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "account_detail", schema = "info")
@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
public class TableAccountDetail {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    /**
     * 设置数据库字段不能为空，内容值唯一
     */
    @Column(name = "account", nullable = false, unique = true)
    private String account;

    @Column(name = "sex")
    private String sex;
}
