package com.yunzainfo.code2.controller;

import com.yunzainfo.code2.entity.YzR;
import com.yunzainfo.code2.entity.param.AccountDetailParam;

import com.yunzainfo.code2.service.AccountDetailService;
import com.yunzainfo.code2.table.TableAccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-detail")
public class AccountDetailController {


    @Autowired
    private  AccountDetailService accountDetailService;


    @PostMapping("/save-account-detail")
    public ResponseEntity<?> saveAccountDetail(@RequestBody AccountDetailParam accountDetailParam){
        TableAccountDetail tableAccountDetail=accountDetailService.saveAccountDetail(accountDetailParam);
        return YzR.ofOk(tableAccountDetail);
    }

    @GetMapping("/list-account-detail-all")
    public ResponseEntity<?> allAccountDetail(){
        return YzR.ofOk(accountDetailService.listAccountDetailAll());
    }

    @PostMapping("/update-accountdetail-phone")
    public ResponseEntity<?> updateAccountDetailPhone(@RequestParam("account")String account,@RequestParam("newPhone")Integer newPhone ){
        TableAccountDetail tableAccountDetail=accountDetailService.updatePhone(account,newPhone);
        return YzR.ofOk(tableAccountDetail);
    }

    @PostMapping("/remove-accountdetail")
    public ResponseEntity<?> removeAccountDetail(@RequestParam("account")String account){
        accountDetailService.removeAccountDetail(account);
        return YzR.ofOk("ok");
    }
}
