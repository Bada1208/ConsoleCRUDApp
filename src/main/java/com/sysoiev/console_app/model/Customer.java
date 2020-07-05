package com.sysoiev.console_app.model;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private Set<Specialty> specialties = new HashSet<>();

    private long id;
    private String name;
    private String surname;
    private Account account;


    public Customer(long id, String name, String surname, Specialty specialty, Account account) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Customer : " + "id=" + id + ", name=" + name + ", surname=" + surname + ", specialties=" + specialties + ", account=" + account;
    }
}
