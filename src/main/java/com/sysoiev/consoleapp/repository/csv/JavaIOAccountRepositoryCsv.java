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
import java.util.Optional;

public class JavaIOAccountRepositoryCsv implements AccountRepository {
    private final String filePath = "src\\main\\resources\\csv\\accounts.csv";
    private List<String> FROM_FILE_LIST;

    {
        try {
            FROM_FILE_LIST = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account getById(Long id) {
        for (String s : FROM_FILE_LIST) {
            if (s.substring(0, s.indexOf(" ")).equals(String.valueOf(id))) {
                return new Account(id, AccountStatus.valueOf(s.substring(s.indexOf(' ') + 1)));
            }
        }
        Optional<Account> empty = Optional.empty();
        return empty.orElseThrow(NullPointerException::new);
    }

    @Override
    public void deleteById(Long id) {
        FROM_FILE_LIST.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (String s : FROM_FILE_LIST) {
                fileWriter.write(s + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Account update(Account item) {
        try {
            for (int i = 0; i < FROM_FILE_LIST.size(); i++) {
                String line = FROM_FILE_LIST.get(i).substring(0, FROM_FILE_LIST.get(i).indexOf(' '));
                if (line.equals(String.valueOf(item.getId()))) {
                    FROM_FILE_LIST.set(i, item.toString());
                }
            }
            Files.write(Paths.get(filePath), FROM_FILE_LIST);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Account save(Account item) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(item.getId() + " " + item.getAccountStatus() + "\n");
            FROM_FILE_LIST.add(item.toString());
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accountList = new ArrayList<>();
        for (String s : FROM_FILE_LIST) {
            accountList.add(
                    new Account(Long.parseLong(s.substring(0, s.indexOf(" "))),
                    AccountStatus.valueOf(s.substring(s.indexOf(" ") + 1)))
            );
        }
        return accountList;
    }
}
