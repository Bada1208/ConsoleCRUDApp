package com.sysoiev.consoleapp.repository.impl;

import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.SpecialtiesRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSpecialtyRepositoryImpl implements SpecialtiesRepository {
    private String filePath = "src\\main\\resources\\specialties.txt";

    @Override
    public Specialty getById(Long id) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : fromFile) {
            if (s.substring(0,s.indexOf(" ")).equals(String.valueOf(id))) {
                return new Specialty(id, s.substring(s.indexOf(' ')));
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        List<String> fromFile = null;
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fromFile.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            for (String s : fromFile) {
                fileWriter.write(s + "\n");
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Specialty update(Specialty item) {
        try {
            List<String> fromFile = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < fromFile.size(); i++) {
                String line = fromFile.get(i).substring(0, fromFile.get(i).indexOf(' '));
                if (line.equals(String.valueOf(item.getId()))) {
                    fromFile.set(i, item.toString());
                }
            }
            Files.write(Paths.get(filePath), fromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Specialty save(Specialty item) {
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            fileWriter.write(item.getId() + " " + item.getSpecialty() + "\n");
        } catch (IOException e) {
            System.out.println(e);
        }
        return item;
    }

    @Override
    public List<Specialty> getAll() {
        List<String> fromFile = null;
        List<Specialty> specialtyList = new ArrayList<>();
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
            for (String s : fromFile) {
                specialtyList.add(new Specialty(Long.parseLong(s.substring(0, s.indexOf(" "))), s.substring(s.indexOf(" "))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return specialtyList;
    }

}
