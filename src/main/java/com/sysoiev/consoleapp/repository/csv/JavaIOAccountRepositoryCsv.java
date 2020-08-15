package com.sysoiev.consoleapp.repository.csv;

import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.AccountStatus;
import com.sysoiev.consoleapp.repository.AccountRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryCsv implements AccountRepository {
    private final String filePath = "src\\main\\resources\\csv\\accounts.csv";

    @Override
    public Account getById(Long id) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : fromFile) {
            if (s.substring(0,s.indexOf(" ")).equals(String.valueOf(id))) {
                return new Account(id, AccountStatus.valueOf(s.substring(s.indexOf(' ') + 1)));
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
    public Account update(Account item) {
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
    public Account save(Account item) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(item.getId() + " " + item.getAccountStatus() + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accountList = new ArrayList<>();
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            for (String s : fromFile) {
                accountList.add(new Account(Long.parseLong(s.substring(0, s.indexOf(" "))), AccountStatus.valueOf(s.substring(s.indexOf(" ")+1))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accountList;
    }
}
