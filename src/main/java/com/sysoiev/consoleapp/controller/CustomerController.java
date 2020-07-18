package com.sysoiev.consoleapp.controller;

import com.sysoiev.consoleapp.model.Customer;
import com.sysoiev.consoleapp.repository.CustomerRepository;
import com.sysoiev.consoleapp.repository.impl.JavaIOCustomerRepositoryImpl;

import java.util.List;

public class CustomerController {
    private CustomerRepository customerRepository = new JavaIOCustomerRepositoryImpl();

    public List<Customer> printAll() {
        return customerRepository.getAll();
    }

    public void saveCustomer(Customer newCustomer) {
        customerRepository.save(newCustomer);
    }

    public void deleteCustomer(long index) {
        customerRepository.deleteById(index);
    }

    public void updateCustomer(Customer updateCustomer) {
        customerRepository.update(updateCustomer);

    }

    public Customer getValueByIndex(long index) {
        return customerRepository.getById(index);
    }
}
