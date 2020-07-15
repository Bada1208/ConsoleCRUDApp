package com.sysoiev.consoleapp.repository.impl;

import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.SpecialtiesRepository;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JavaIOSpecialtyRepositoryImpl implements SpecialtiesRepository {

    private String filePath = "C:\\Users\\Admin\\IdeaProjects\\ConsoleCRUDApp\\src\\main\\resources\\specialties.txt";
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<String> fromFile;

    @Override
    public Specialty getById(Long id) {
        String idStr = String.valueOf(id);
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : fromFile) {
            if (s.startsWith(idStr)) {
                return new Specialty(id, s.substring(s.indexOf(' ')));
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        fromFile.removeIf(s -> s.startsWith(String.valueOf(id)));
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
            fromFile = Files.readAllLines(Paths.get(filePath));
            for (int i = 0; i < fromFile.size(); i++) {
                String line = fromFile.get(i).substring(0, fromFile.get(i).indexOf(' '));
                if (line.equals(String.valueOf(item.getId()))) {
                    fromFile.set(i,item.toString());
                }
            }
            Files.write(Paths.get(filePath),fromFile);
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
    public List<String> getAll() {
        try {
            fromFile = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fromFile;
    }

}
