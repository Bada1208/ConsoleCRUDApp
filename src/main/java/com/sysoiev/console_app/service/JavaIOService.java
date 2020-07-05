package com.sysoiev.console_app.service;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class JavaIOService {
    String filePath;

    public JavaIOService(String filePath) {
        this.filePath = filePath;
    }

    public void createFile(String filePath) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw")) {
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void readFile(String filePath) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r")) {
            String res = "";
            int b = randomAccessFile.read();
            while (b != -1) {
                res = res + (char) b;
                b = randomAccessFile.read();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeToFile(String filePath) {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "rw")) {
            randomAccessFile.write(filePath.getBytes());
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public void editFile(String filePath){

    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        try (RandomAccessFile randomFile = new RandomAccessFile(file, "rw")) {
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        file.deleteOnExit();
    }
}
