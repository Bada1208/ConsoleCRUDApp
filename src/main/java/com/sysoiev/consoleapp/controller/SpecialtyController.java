package com.sysoiev.consoleapp.controller;

import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.SpecialtiesRepository;
import com.sysoiev.consoleapp.repository.impl.JavaIOSpecialtyRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SpecialtyController {
    private SpecialtiesRepository specialtyRepository = new JavaIOSpecialtyRepositoryImpl();


    public List<String> printAll() {
        return specialtyRepository.getAll();
    }

    public void saveSpecialty(Specialty newSpecialty) {
        specialtyRepository.save(newSpecialty);
    }

    public void deleteSpecialty(long index) {
        specialtyRepository.deleteById(index);
    }

    public void updateSpecialty(Specialty updateSpecialty) {
        specialtyRepository.update(updateSpecialty);

    }

    public Specialty getValueByIndex(long index) throws IOException {
        return specialtyRepository.getById(index);
    }

}
