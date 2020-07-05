package com.sysoiev.console_app;

import com.sysoiev.console_app.model.Account;
import com.sysoiev.console_app.model.AccountStatus;
import com.sysoiev.console_app.model.Customer;
import com.sysoiev.console_app.model.Specialty;

public class App {
    public static void main(String[] args) {
        Account account = new Account(AccountStatus.DELETED);
        System.out.println(account);
        Specialty specialty = new Specialty("driver");
        Customer customer = new Customer(specialty, account);
        System.out.println(customer.toString());
    }
}
