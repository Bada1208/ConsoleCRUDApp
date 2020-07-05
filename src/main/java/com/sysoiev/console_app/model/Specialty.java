package com.sysoiev.console_app.model;

public class Specialty {
    private String specialty;

    public Specialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "specialty=" + specialty;
    }
}
