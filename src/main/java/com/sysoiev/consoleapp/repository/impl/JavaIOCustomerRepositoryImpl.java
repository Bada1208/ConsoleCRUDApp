package com.sysoiev.consoleapp.repository.impl;

import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.AccountStatus;
import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.CustomerRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaIOCustomerRepositoryImpl implements CustomerRepository {
    private String filePath = "src\\main\\resources\\customers.txt";

    @Override
    public Customer getById(Long id) {

        String idStr = String.valueOf(id);
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : fromFile) {
            if (s.startsWith(idStr)) {
                List<String> stringList = Stream
                        .of(s.split(" "))
                        .map(elem -> new String(elem))
                        .collect(Collectors.toList());
                Set<Specialty> specialtySet = new HashSet<>(Arrays.asList(new Specialty(stringList.get(3))));
                return new Customer(id, stringList.get(1), stringList.get(2), specialtySet, new Account(AccountStatus.valueOf(stringList.get(4))));
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
        fromFile.removeIf(s -> s.startsWith(String.valueOf(id)));
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
            fileWriter.write(item.getId() + " " + item.getName() + item.getSurname() + item.getSpecialties() + item.getAccount() + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<String> getAll() {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromFile;
    }
}
