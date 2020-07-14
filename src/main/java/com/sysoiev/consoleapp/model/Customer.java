package com.sysoiev.consoleapp.model;

import java.util.Set;

public class Customer {

    private long id;
    private String name;
    private String surname;
    private Account account;
    private Set<Specialty> specialties;

    public Customer(long id, String name, String surname, Set<Specialty> specialties, Account account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialties = specialties;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + account + " " + specialties;
    }
}