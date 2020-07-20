package com.sysoiev.consoleapp.view;

import com.sysoiev.consoleapp.controller.CustomerController;
import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.model.Specialty;

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
        System.out.println(customerController.getValueByIndex(id).toString());
    }


    public void saveCustomer() {
        System.out.println("Enter id : ");
        Long id = Long.parseLong(scanner.next());
        System.out.println("Enter name :");
        String name = scanner.next();
        System.out.println("Enter surname :");
        String surname = scanner.next();
        System.out.println("Enter specialty :");
        Set<Specialty> specialtySet = new HashSet<>();
        String specialty = scanner.next();
        specialtySet.add(new Specialty(specialty));
        boolean go = true;
        while (go) {
            System.out.println("Do You want to add new specialty? 1.Yes 2.No");
            String yesOrNo = scanner.next();
            switch (yesOrNo) {
                case ("1"):
                    System.out.println("Enter new specialty :");
                    String newSpecialty = scanner.next();
                    specialtySet.add(new Specialty(newSpecialty));
                    break;
                case ("2"):
                    System.out.println("You choose do not add new specialty");
                    go = false;
                    break;
            }
        }
        System.out.println("Enter id of account :");
        Long idAccount = Long.parseLong(scanner.next());
        Account account = new Account(idAccount);
        Customer newCustomer = new Customer(id, name, surname, specialtySet, account);
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
        Set<Specialty> specialtySet = new HashSet<>();
        String specialty = scanner.next();
        specialtySet.add(new Specialty(specialty));

        boolean go = true;
        while (go) {
            System.out.println("Do You want to add new specialty? 1.Yes 2.No");
            String yesOrNo = scanner.next();
            switch (yesOrNo) {
                case ("1"):
                    System.out.println("Enter new specialty :");
                    String newSpecialty = scanner.next();
                    specialtySet.add(new Specialty(newSpecialty));
                    break;
                case ("2"):
                    System.out.println("You choose do not add new specialty");
                    go = false;
                    break;
            }
        }
        System.out.println("Enter id of account :");
        Long idAccount = Long.parseLong(scanner.next());
        Account account = new Account(idAccount);
        Customer newCustomer = new Customer(id, name, surname, specialtySet, account);
        customerController.updateCustomer(newCustomer);
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
