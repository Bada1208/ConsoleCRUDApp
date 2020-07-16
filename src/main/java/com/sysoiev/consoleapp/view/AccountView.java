package com.sysoiev.consoleapp.view;

import com.sysoiev.consoleapp.controller.AccountController;
import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.AccountStatus;

import java.io.IOException;
import java.util.Scanner;

public class AccountView {
    private Scanner scanner = new Scanner(System.in);
    private AccountController accountController = new AccountController();


    public void printAccounts() {
        System.out.println("List of all accounts : ");
        System.out.println(accountController.printAll());
    }

    public void deleteAccount() {
        System.out.println("Enter id in order to delete row : ");
        long index = Long.parseLong(scanner.next());
        accountController.deleteAccount(index);
    }

    public void getByIdAccount() {
        System.out.println("Enter id in order to get account :");
        long id = Long.parseLong(scanner.next());
        try {
            System.out.println(accountController.getValueByIndex(id).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAccount() {
        System.out.println("Enter id : ");
        Long id = Long.parseLong(scanner.next());
        Account newAccount = new Account(id, AccountStatus.ACTIVE);
        accountController.saveAccount(newAccount);
    }

    public void updateAccount() {
        System.out.println("Enter id in order to find element :");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter new status : ACTIVE, DELETED or BANNED");
        String accountStatusStr = scanner.next();
        AccountStatus accountStatusVar = null;
        switch (accountStatusStr) {
            case "ACTIVE":
                accountStatusVar = AccountStatus.ACTIVE;
            case "DELETED":
                accountStatusVar = AccountStatus.DELETED;
            case "BANNED":
                accountStatusVar = AccountStatus.BANNED;
        }
        Account newAccount = new Account(id, accountStatusVar);
        accountController.updateAccount(newAccount);
    }

    public void run() {
        boolean go = true;
        while (go) {
            System.out.println("\nChoose option, please :");
            System.out.println("Enter number : ");
            System.out.println("1. Show all rows");
            System.out.println("2. Insert new row");
            System.out.println("3. Delete row ");
            System.out.println("4. Update row  ");
            System.out.println("5. Search by id ");
            System.out.println("6. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    printAccounts();
                    break;
                case 2:
                    saveAccount();
                    break;
                case 3:
                    deleteAccount();
                    break;
                case 4:
                    updateAccount();
                    break;
                case 5:
                    getByIdAccount();
                    break;
                case 6:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 6, please");
            }
        }
    }
}
