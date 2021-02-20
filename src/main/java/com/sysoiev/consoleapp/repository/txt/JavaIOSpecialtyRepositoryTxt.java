package com.sysoiev.consoleapp.repository.txt;

import com.sysoiev.consoleapp.model.Specialty;
import com.sysoiev.consoleapp.repository.SpecialtiesRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSpecialtyRepositoryTxt implements SpecialtiesRepository {
    private final String filePath = "src\\main\\resources\\txt\\specialties.txt";
    private List<String> FROM_FILE_LIST;


    {
        try {
            FROM_FILE_LIST = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Specialty getById(Long id) {
        for (String s : FROM_FILE_LIST) {
            if (s.substring(0, s.indexOf(" ")).equals(String.valueOf(id))) {
                return new Specialty(id, s.substring(s.indexOf(' ')));
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            FROM_FILE_LIST.removeIf(s -> (s.substring(0, s.indexOf(" "))).equals(String.valueOf(id)));
            FileWriter fileWriter = new FileWriter(filePath);
            for (String s : FROM_FILE_LIST) {
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public Specialty update(Specialty item) {
        try {
            for (int i = 0; i < FROM_FILE_LIST.size(); i++) {
                String line = FROM_FILE_LIST.get(i).substring(0, FROM_FILE_LIST.get(i).indexOf(' '));
                if (line.equals(String.valueOf(item.getId()))) {
                    FROM_FILE_LIST.set(i, item.toString());
                }
            }
            Files.write(Paths.get(filePath), FROM_FILE_LIST);
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
        List<Specialty> specialtyList = new ArrayList<>();
        for (String s : FROM_FILE_LIST) {
            specialtyList.add(new Specialty(Long.parseLong(s.substring(0, s.indexOf(" "))), s.substring(s.indexOf(" "))));
        }
        return specialtyList;
    }

}
