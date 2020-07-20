package com.sysoiev.consoleapp.model;

import java.util.Set;

public class Customer {
    private Long id;
    private String name;
    private String surname;
    private Account account;
    private Set<Specialty> specialties;

    public Customer(Long id, String name, String surname, Set<Specialty> specialties, Account account) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialties = specialties;
        this.account = account;
    }

    public Customer(String name, String surname, Set<Specialty> specialties, Account account) {
        this.name = name;
        this.surname = surname;
        this.specialties = specialties;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSpecialties(Specialty specialty) {
        specialties.add(specialty);
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

    public Account getAccount() {
        return account;
    }

    public String getSpecialties() {
        String specialtyString = "";
        for (Specialty s : specialties) {
            specialtyString += "{" + s.getId() + "}";
        }
        return specialtyString;
    }

    @Override
    public String toString() {
        return id + "/ " + name + "/ " + surname + "/ " + getSpecialties() + " /" + account.getId();
    }
}