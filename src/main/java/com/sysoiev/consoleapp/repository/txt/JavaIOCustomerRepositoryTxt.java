package com.sysoiev.consoleapp.repository.txt;

import com.sysoiev.consoleapp.model.Account;
import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.AccountRepository;
import com.sysoiev.consoleapp.repository.CustomerRepository;
import com.sysoiev.consoleapp.repository.SpecialtiesRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaIOCustomerRepositoryTxt implements CustomerRepository {
    private final String filePath = "src\\main\\resources\\txt\\customers.txt";
    private SpecialtiesRepository specialtiesRepository = new JavaIOSpecialtyRepositoryTxt();
    private AccountRepository accountRepository = new JavaIOAccountRepositoryTxt();

    @Override
    public Customer getById(Long id) {
        List<String> fromFile;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            String line;
            for (String s : fromFile) {
                line = s.substring(0, s.indexOf("/"));
                if (line.equals(String.valueOf(id))) {
                    List<String> stringList = Stream
                            .of(s.split(" "))
                            .map(elem -> elem.replaceAll("[\\/\\/]", ""))
                            .collect(Collectors.toList());
                    String name = stringList.get(1);// + " "
                    String surname = stringList.get(2);// + " "
                    String lineSet = stringList.get(3);
                    String lineWithoutBrackets = lineSet.replaceAll("[{]", "");
                    String lineWithoutBrackets2 = lineWithoutBrackets.replaceAll("[}]", " ");
                    List<String> stringList2 = Stream
                            .of(lineWithoutBrackets2.split(" "))
                            .collect(Collectors.toList());
                    Set<Specialty> specialtySet = new HashSet<>();
                    for (String str : stringList2) {
                        Specialty specialty = specialtiesRepository.getById(Long.valueOf(str));
                        specialtySet.add(specialty);
                    }
                    Account account = accountRepository.getById(Long.valueOf(stringList.get(4)));
                    return new Customer.CustomerBuilder(name, surname, specialtySet, account).id(id).buildCustomer();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        List<String> fromFile;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            fromFile.removeIf(s -> (s.substring(0, s.indexOf("/"))).equals(String.valueOf(id)));
            FileWriter fileWriter = new FileWriter(filePath);
            for (String s : fromFile) {
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer update(Customer item) {
        List<String> fromFile;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < fromFile.size(); i++) {
                String line = fromFile.get(i).substring(0, fromFile.get(i).indexOf("/"));
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
            fileWriter.write(item + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> customerList = new ArrayList<>();
        List<String> fromFile;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            for (String stringFromFile : fromFile) {
                List<String> stringList = Stream
                        .of(stringFromFile.split(" "))
                        .map(elem -> elem.replaceAll("[\\/\\/]", ""))
                        .collect(Collectors.toList());
                Long id = Long.parseLong(stringList.get(0));
                String name = stringList.get(1);// + " "
                String surname = stringList.get(2);// + " "
                String lineSet = stringList.get(3);
                String lineWithoutBrackets = lineSet.replaceAll("[{]", "");
                String lineWithoutBrackets2 = lineWithoutBrackets.replaceAll("[}]", " ");
                List<String> stringList2 = Stream
                        .of(lineWithoutBrackets2.split(" "))
                        .collect(Collectors.toList());
                Set<Specialty> specialtySet = new HashSet<>();
                for (String str : stringList2) {
                    Specialty specialty = specialtiesRepository.getById(Long.valueOf(str));
                    specialtySet.add(specialty);
                }
                Account account = accountRepository.getById(Long.valueOf(stringList.get(4)));
                customerList.add(new Customer.CustomerBuilder(name, surname, specialtySet, account).id(id).buildCustomer());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
