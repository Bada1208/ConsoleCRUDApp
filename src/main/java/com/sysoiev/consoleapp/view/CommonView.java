package com.sysoiev.consoleapp.view;

import java.util.Scanner;

public class CommonView {

    SpecialtyView specialtyView = new SpecialtyView();
    AccountView accountView = new AccountView();
    CustomerView customerView = new CustomerView();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean go = true;
        while (go) {
            System.out.println("\nChoose file in order to do operations , please :");
            System.out.println("Enter number : ");
            System.out.println("1.Specialties");
            System.out.println("2.Accounts");
            System.out.println("3.Customers");
            System.out.println("4. End ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runSpecialty();
                    break;
                case 2:
                    runAccount();
                    break;
                case 3:
                    runCustomer();
                    break;
                case 4:
                    go = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    System.out.println("Enter number from 1 to 4, please");
            }
        }
    }

    public void runSpecialty() {
        specialtyView.run();
    }

    public void runAccount() {
        accountView.run();
    }

    public void runCustomer() {
        customerView.run();
    }

}
