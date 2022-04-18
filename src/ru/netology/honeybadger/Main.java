package ru.netology.honeybadger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    private static StringBuilder log = new StringBuilder();
    private static Date dateNow = new Date();

    public static void main(String[] args) {
        List<String> arrayDirectories = Arrays.asList("G://Games", "G://Games/src", "G://Games/res", "G://Games/savegames", "G://Games/temp",
                "G://Games/src/main", "G://Games/src/test", "G://Games/res/drawables", "G://Games/res/vectors", "G://Games/res/icons");
        for (String directory : arrayDirectories) {
            createdDirectory(createdInstanceFileDirectory(directory));
        }
        List<String> arrayFiles = Arrays.asList("G://Games/src/main/Main.java", "G://Games/src/main/Utils.java.");
        for (String file : arrayFiles) {
            createdFile(createdInstanceFileDirectory(file));
        }
        File fileTemp = createdInstanceFileDirectory("G://Games/temp/temp.txt");
        createdFile(fileTemp);
        try (FileWriter fileWriter = new FileWriter(fileTemp, false)) {
            fileWriter.write(log.toString());
            fileWriter.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println(log);
    }

    private static File createdInstanceFileDirectory(String directoryName) {
        File instanceFile = new File(directoryName);
        return instanceFile;
    }

    private static void createdDirectory(File file) {
        if (file.mkdir()) {
            //System.out.printf("Directory %s created!\n", file.getName());
            log.append(dateNow.toString());
            log.append(" Directory ");
            log.append(file.getName());
            log.append(" created!\n");
        } else if (file.exists()) {
            //System.out.printf("Directory  %s exists\n", file.getName());
            log.append(dateNow.toString());
            log.append(" Directory ");
            log.append(file.getName());
            log.append(" exists!\n");
        } else {
            //System.out.printf("With %s Something went wrong...",file.getName());
            log.append(dateNow.toString());
            log.append("With ");
            log.append(file.getName());
            log.append(" Something went wrong...\n");
        }
    }

    private static void createdFile(File file) {
        if (file.exists()) {
            //System.out.printf("File %s exists\n", file.getName());
            log.append(dateNow.toString());
            log.append(" File ");
            log.append(file.getName());
            log.append(" exists!\n");
        } else {
            try {
                if (file.createNewFile()) {
                    //System.out.printf("File %s created\n", file.getName());
                    log.append(dateNow.toString());
                    log.append(" File ");
                    log.append(file.getName());
                    log.append(" created!\n");
                }
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}

