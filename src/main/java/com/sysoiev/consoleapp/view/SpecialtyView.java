package com.sysoiev.consoleapp.view;

import com.sysoiev.consoleapp.controller.SpecialtyController;
import com.sysoiev.consoleapp.model.Specialty;

import java.util.Scanner;

public class SpecialtyView {
    private Scanner scanner;
    private SpecialtyController specialtyController = new SpecialtyController();

    public void printSpecialties() {
        System.out.println("List of all specialties : ");
        System.out.println(specialtyController.printAll());
    }

    public void deleteSpecialty() {
        scanner = new Scanner(System.in);
        System.out.println("Enter id in order to delete row : ");
        long index = Long.parseLong(scanner.next());
        specialtyController.deleteSpecialty(index);
    }

    public void getByIdSpecialty() {
        scanner = new Scanner(System.in);
        System.out.println("Enter id in order to get specialty :");
        long id = Long.parseLong(scanner.next());
        System.out.println(specialtyController.getValueByIndex(id).toString());
    }

    public void saveSpecialty() {
        scanner = new Scanner(System.in);
        System.out.println("Enter new id : ");
        Long id =Long.parseLong(scanner.next());
        System.out.println("Enter new Specialty : ");
        String specialty = scanner.next();
        Specialty newSpecialty = new Specialty(id,specialty);
        specialtyController.saveSpecialty(newSpecialty);
    }
    public void updateSpecialty() {

    }
    public void run() {
        scanner = new Scanner(System.in);
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
                    printSpecialties();
                    break;
                case 2:
                    saveSpecialty();
                    break;
                case 3:
                    deleteSpecialty();
                    break;
                case 4:
                    updateSpecialty();
                    break;
                case 5:
                    getByIdSpecialty();
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
