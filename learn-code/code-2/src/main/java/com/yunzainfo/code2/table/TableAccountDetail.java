package com.yunzainfo.code2.table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @Column(name = "account", nullable = false, unique = true)
    private String account;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "age")
    private Integer age;

    @Column(name = "num_kind")
    private String numKind;

    @Column(name = "number")
    private Integer number;

    @Column(name = "phone")
    private Integer phone;

}
