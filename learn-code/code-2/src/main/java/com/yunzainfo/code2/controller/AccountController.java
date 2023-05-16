package com.yunzainfo.code2.controller;

import com.yunzainfo.code2.entity.YzR;
import com.yunzainfo.code2.entity.param.AccountParam;
import com.yunzainfo.code2.service.AccountService;
import com.yunzainfo.code2.table.TableAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lemon
 * @date 2022/5/19 19:42
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 在URL的单词使用 - 分割
     *
     * @return
     */
    @GetMapping("/list-account-all")
    public ResponseEntity<?> listAccountAll() {
        List<TableAccount> tableAccounts = accountService.listAccountAll();
        return YzR.ofOk(tableAccounts);
    }

    @PostMapping("/save-account")
    public ResponseEntity<?> saveAccount(@RequestBody AccountParam param) {
        TableAccount tableAccount = accountService.saveAccount(param.getAccount(), param.getPasswordText());
        return YzR.ofOk(tableAccount);
    }

    @PostMapping("/update-password")
    public ResponseEntity<?> updatePassword(@RequestBody AccountParam param){
        TableAccount tableAccount=accountService.updatePassword(param.getAccount(), param.getPasswordText(),param.getNewPasswordText() );
        return YzR.ofOk(tableAccount);
    }

    @PostMapping("/update-account-lock")
    public ResponseEntity<?> changeAccountLock(@RequestParam("account")String account, @RequestParam("lock")Integer lock){
        TableAccount tableAccount=accountService.changeAccountLock(account,lock);
        return YzR.ofOk(tableAccount);
    }

    @GetMapping("/remove-account")
    public ResponseEntity<?> removeAccount(@RequestParam("account")String account){
        accountService.removeAccount(account);
        return YzR.ofOk("OK");
    }

    @GetMapping("/check-account")
    public ResponseEntity<?> validatedPasswordByAccount(@RequestParam("account")String account,@RequestParam("passwordMd5")String passwordMd5){
      return  YzR.ofOk(accountService.validatedPasswordByAccount(account,passwordMd5));
    }

    @GetMapping("/list-account-page")
    public ResponseEntity<?> listAccountByPage(@RequestParam("pageIndex")Integer pageIndex,@RequestParam("pageSize")Integer pageSize){
        System.out.println(pageIndex+"++++++++++++++++++++"+pageSize);
        List<TableAccount> lists=accountService.listAccountByPage(pageIndex,pageSize);
        return YzR.ofOk(lists);
    }

}
