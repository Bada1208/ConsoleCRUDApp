package com.sysoiev.consoleapp;

import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.AccountStatus;
import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.model.Specialty;

public class App {
    public static void main(String[] args) {
        Account account = new Account(AccountStatus.DELETED);
        System.out.println(account);
        Specialty specialty = new Specialty("driver");
        Customer customer = new Customer(specialty, account);
        System.out.println(customer.toString());
    }
}
