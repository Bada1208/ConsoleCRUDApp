package com.sysoiev.consoleapp.repository.impl;

import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.AccountStatus;
import com.sysoiev.consoleapp.repository.AccountRepository;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {
    private String filePath = "C:\\Users\\Admin\\IdeaProjects\\ConsoleCRUDApp\\src\\main\\resources\\accounts.txt";
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private List<Account> accountList = new ArrayList<>();

    @Override
    public Account getById(Long id) {
        for (Account account : accountList) {
            if (account.getId() == id) return account;
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        accountList.removeIf(s -> s.getId() == id);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Account a : accountList) {
                fileWriter.write(a + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Account update(Account item){
//        System.out.println("Enter new id in order to update a row, please ");
//        Long newId = Long.parseLong(reader.readLine());
//
//        if(newId==1) return new Account(1,AccountStatus.ACTIVE);
//        else if(newId==2) return new Account(2,AccountStatus.BANNED);
//        else if(newId==3) return new Account(3,AccountStatus.DELETED);
//        item.setId(newId);
//        try (FileWriter fileWriter = new FileWriter(filePath)) {
//            for (Account a : accountList) {
//                fileWriter.write(a + "\n");
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
        return item;
    }

    @Override
    public Account save(Account item) {
        accountList.add(item);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Account a : accountList) {
                fileWriter.write(a + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<String> getAll() {
        return null;
    }
}
