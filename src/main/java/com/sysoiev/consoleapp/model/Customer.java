package com.sysoiev.consoleapp.model;

import java.util.Set;

public class Customer {

    private long id;
    private String name;
    private String surname;
    private AccountStatus accountStatus;
    private Set<Specialty> specialties;

    public Customer(long id, String name, String surname, Set<Specialty> specialties, AccountStatus accountStatus) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specialties = specialties;
        this.accountStatus = accountStatus;
    }

    public Customer(String name, String surname, Set<Specialty> specialties, AccountStatus accountStatus) {
        this.name = name;
        this.surname = surname;
        this.specialties = specialties;
        this.accountStatus = accountStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getSpecialties() {
        String specialtyString = null;
        for (Specialty s : specialties) {
            specialtyString = s.getSpecialty();
        }
        return specialtyString;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname + " " + getSpecialties() + " " + accountStatus;
    }
}