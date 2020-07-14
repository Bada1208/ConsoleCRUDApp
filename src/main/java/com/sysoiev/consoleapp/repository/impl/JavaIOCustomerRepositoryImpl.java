package com.sysoiev.consoleapp.repository.impl;

import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.CustomerRepository;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaIOCustomerRepositoryImpl implements CustomerRepository {
    private String filePath = "C:\\Users\\Admin\\IdeaProjects\\ConsoleCRUDApp\\src\\main\\resources\\customers.txt";
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private List<Customer> customerList = new ArrayList<>();
    private Set<Specialty> specialties = new HashSet<>();

    @Override
    public Customer getById(Long id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) return customer;
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        customerList.removeIf(s -> s.getId() == id);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Customer c : customerList) {
                fileWriter.write(c + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    @Override
    public Customer update(Customer item) throws IOException {
        System.out.println("Enter new id in order to update a row, please ");
        Long newId = Long.parseLong(reader.readLine());
        item.setId(newId);
        System.out.println("Enter new name in order to update a row, please ");
        String newName = reader.readLine();
        item.setName(newName);
        System.out.println("Enter new surname in order to update a row, please ");
        String newSurname = reader.readLine();
        item.setSurname(newSurname);
        System.out.println("Enter new specialty in order to update a row, please ");
        String newSpecialty = reader.readLine();
        item.setSpecialties(new Specialty(newSpecialty));
        System.out.println("Choose account status : active, banned or delete");
        String newStatus = reader.readLine();
        if (newStatus.equals("active")) {
        }
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Customer c : customerList) {
                fileWriter.write(c + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }


    @Override
    public Customer save(Customer item) {
        customerList.add(item);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Customer c : customerList) {
                fileWriter.write(c + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }
}
