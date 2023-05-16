package com.yunzainfo.code2.repository;


import com.yunzainfo.code2.table.TableAccountDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailRepository extends JpaRepository<TableAccountDetail,String> {

    TableAccountDetail findAllByAccount(String account);

    void deleteAllByAccount(String account);

}
