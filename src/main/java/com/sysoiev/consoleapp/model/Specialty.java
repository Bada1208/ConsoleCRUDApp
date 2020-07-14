package com.sysoiev.consoleapp.model;

public class Specialty {
    private long id;
    private String specialty;

    public Specialty(String specialty) {
        this.specialty = specialty;
    }

    public Specialty(long id, String specialty) {
        this.id = id;
        this.specialty = specialty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return id + " " + specialty;
    }
}
