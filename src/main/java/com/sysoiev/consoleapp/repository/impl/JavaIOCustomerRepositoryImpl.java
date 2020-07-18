package com.sysoiev.consoleapp.repository.impl;

import com.sysoiev.consoleapp.model.AccountStatus;
import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.CustomerRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaIOCustomerRepositoryImpl implements CustomerRepository {
    private String filePath = "src\\main\\resources\\customers.txt";

    @Override
    public Customer getById(Long id) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String line;
        for (String s : fromFile) {
            line = s.substring(0, s.indexOf(" "));
            if (line.equals(String.valueOf(id))) {
                List<String> stringList = Stream
                        .of(s.split(" "))
                        .map(elem -> new String(elem.replaceAll("[\\[\\]]", "")))
                        .collect(Collectors.toList());
                String name = stringList.get(1) + " ";
                String surname = stringList.get(2) + " ";
                Set<Specialty> specialtySet = new HashSet<>(Arrays.asList(new Specialty(stringList.get(3) + " ")));
                AccountStatus accountStatus = AccountStatus.valueOf(stringList.get(4));
                return new Customer(id, name, surname, specialtySet, accountStatus);
            }

        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fromFile.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (String s : fromFile) {
                fileWriter.write(s + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Customer update(Customer item) {
        try {
            List<String> fromFile = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < fromFile.size(); i++) {
                String line = fromFile.get(i).substring(0, fromFile.get(i).indexOf(' '));
                if (line.equals(String.valueOf(item.getId()))) {
                    fromFile.set(i, item.toString());
                }
            }
            Files.write(Paths.get(filePath), fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Customer save(Customer item) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(item.getId() + " " + item.getName() + " " + item.getSurname() + " " + item.getSpecialties() + " " + item.getAccountStatus() + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Customer> getAll() {
        List<String> fromFile = null;
        List<Customer> customerList = new ArrayList<>();
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            for (String s : fromFile) {
                List<String> stringList = Stream
                        .of(s.split(" "))
                        .map(elem -> new String(elem.replaceAll("[\\[\\]]", "")))
                        .collect(Collectors.toList());

                Long id = Long.parseLong(stringList.get(0));
                String name = stringList.get(1) + " ";
                String surname = stringList.get(2) + " ";
                Set<Specialty> specialtySet = new HashSet<>(Arrays.asList(new Specialty(stringList.get(3) + " ")));
                AccountStatus accountStatus = AccountStatus.valueOf(stringList.get(4));
                customerList.add(new Customer(id, name, surname, specialtySet, accountStatus));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
