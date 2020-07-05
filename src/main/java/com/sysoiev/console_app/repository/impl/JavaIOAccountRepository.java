package com.sysoiev.console_app.repository.impl;

import com.sysoiev.console_app.model.Account;
import com.sysoiev.console_app.repository.AccountRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JavaIOAccountRepository implements AccountRepository {
    private final static String path = "accounts.txt";
    Account account = null;

    @Override
    public Account getByIndexInCollection(Integer id) throws IOException {
        List<String> accountList = Files.readAllLines(Paths.get(path));
        for (String s : accountList) {
            if ((account.toString()).equals(s)) return account;
            break;
        }
        return account;
    }

    @Override
    public void delete(Account item) throws IOException {
        List<String> accountList = Files.readAllLines(Paths.get(path));
        for (String s : accountList) {
            if ((account.toString()).equals(s)) accountList.remove(account);
            break;
        }
    }

    @Override
    public void update(Account item) {

    }

    @Override
    public List<Account> getList() {
        return null;
    }
}
