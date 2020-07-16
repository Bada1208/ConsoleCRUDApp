package com.sysoiev.consoleapp.controller;

import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.repository.AccountRepository;
import com.sysoiev.consoleapp.repository.impl.JavaIOAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class AccountController {

    private AccountRepository accountRepository = new JavaIOAccountRepositoryImpl();


    public List<String> printAll() {
        return accountRepository.getAll();
    }

    public void saveAccount(Account newAccount) {
        accountRepository.save(newAccount);
    }

    public void deleteAccount(long index) {
        accountRepository.deleteById(index);
    }

    public void updateAccount(Account updateAccount) {
        accountRepository.update(updateAccount);

    }

    public Account getValueByIndex(long index) throws IOException {
        return accountRepository.getById(index);
    }
}