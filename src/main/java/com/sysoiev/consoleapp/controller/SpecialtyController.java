package com.sysoiev.consoleapp.controller;

import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.SpecialtiesRepository;
import com.sysoiev.consoleapp.repository.csv.JavaIOSpecialtyRepositoryCsv;

import java.util.List;

public class SpecialtyController {
    private SpecialtiesRepository specialtyRepository = new JavaIOSpecialtyRepositoryCsv();


    public List<Specialty> printAll() {
        return specialtyRepository.getAll();
    }

    public void saveSpecialty(Specialty newSpecialty) {
        specialtyRepository.save(newSpecialty);
    }

    public void deleteSpecialty(Long index) {
        specialtyRepository.deleteById(index);
    }

    public void updateSpecialty(Specialty updateSpecialty) {
        specialtyRepository.update(updateSpecialty);

    }

    public Specialty getValueByIndex(Long index){
        return specialtyRepository.getById(index);
    }

}
