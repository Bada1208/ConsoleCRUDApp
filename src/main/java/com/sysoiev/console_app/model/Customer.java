package com.sysoiev.console_app.model;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private Set<Specialty> specialties = new HashSet<>();

    private String name;
    private String surname;
    private Account account;


    public Customer(String name, String surname, Specialty specialty, Account account) {
        this.name = name;
        this.surname = surname;
        specialties.add(specialty);
        this.account = account;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
