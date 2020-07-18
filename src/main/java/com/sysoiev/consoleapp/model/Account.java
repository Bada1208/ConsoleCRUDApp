package com.sysoiev.consoleapp.model;

public class Account {
    private static long counter = 0;
    private long id;
    private AccountStatus accountStatus;

    public Account(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Account(long id, AccountStatus accountStatus) {
        this.id = id;
        this.accountStatus = accountStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return id + " " + accountStatus;
    }
}
