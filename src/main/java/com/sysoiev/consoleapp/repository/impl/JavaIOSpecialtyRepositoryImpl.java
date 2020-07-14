package com.sysoiev.consoleapp.repository.impl;

import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.SpecialtiesRepository;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSpecialtyRepositoryImpl implements SpecialtiesRepository {

    private String filePath = "C:\\Users\\Admin\\IdeaProjects\\ConsoleCRUDApp\\src\\main\\resources\\specialties.txt";
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private List<Specialty> specialtyList = new ArrayList<>();

    @Override
    public Specialty getById(Long id) {
        for (Specialty specialty : specialtyList) {
            if (specialty.getId() == id) return specialty;
        }
        return null;
    }

    @Override
    public void deleteById(Long id){
        specialtyList.removeIf(s -> s.getId() == id);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Specialty s : specialtyList) {
                fileWriter.write(s + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Specialty update(Specialty item) throws IOException {
        System.out.println("Enter new id in order to update a row, please ");
        Long newId = Long.parseLong(reader.readLine());
        System.out.println("Enter specialty in order to update a row, please ");
        String newSpecialty = reader.readLine();
        item.setId(newId);
        item.setSpecialty(newSpecialty);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Specialty s : specialtyList) {
                fileWriter.write(s + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public Specialty save(Specialty item) {
        specialtyList.add(item);
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (Specialty s : specialtyList) {
                fileWriter.write(s + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Specialty> getAll() {
        return specialtyList;
    }

}
