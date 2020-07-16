package com.sysoiev.consoleapp.view;

import com.sysoiev.consoleapp.controller.CustomerController;
import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.AccountStatus;
import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.model.Specialty;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CustomerView {
    private Scanner scanner = new Scanner(System.in);
    private CustomerController customerController = new CustomerController();


    public void printCustomers() {
        System.out.println("List of all customers : ");
        System.out.println(customerController.printAll());
    }

    public void deleteCustomer() {
        System.out.println("Enter id in order to delete row : ");
        long index = Long.parseLong(scanner.next());
        customerController.deleteCustomer(index);
    }

    public void getByIdCustomer() {
        System.out.println("Enter id in order to get customer :");
        long id = Long.parseLong(scanner.next());
        try {
            System.out.println(customerController.getValueByIndex(id).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public Customer(long id, String name, String surname, Set<Specialty> specialties, Account account)
    public void saveCustomer() {
        System.out.println("Enter id : ");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter name :");
        String name = scanner.next();
        System.out.println("Enter surname :");
        String surname = scanner.next();
        System.out.println("Enter specialty :");
        String specialty = scanner.next();
        System.out.println("Enter status : ACTIVE, DELETED or BANNED");
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
        Set<Specialty> specialtySet = new HashSet<>(Arrays.asList(new Specialty(specialty)));
        Customer newCustomer = new Customer(id, name, surname, specialtySet, new Account(accountStatusVar));
        customerController.saveCustomer(newCustomer);
    }

    public void updateCustomer() {
        System.out.println("Enter id in order to find element :");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter name :");
        String name = scanner.next();
        System.out.println("Enter surname :");
        String surname = scanner.next();
        System.out.println("Enter specialty :");
        String specialty = scanner.next();
        System.out.println("Enter status : ACTIVE, DELETED or BANNED");
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
        Set<Specialty> specialtySet = new HashSet<>(Arrays.asList(new Specialty(specialty)));
        Customer newCustomer = new Customer(name, surname, specialtySet, new Account(accountStatusVar));
        customerController.saveCustomer(newCustomer);
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
                    printCustomers();
                    break;
                case 2:
                    saveCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    getByIdCustomer();
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
