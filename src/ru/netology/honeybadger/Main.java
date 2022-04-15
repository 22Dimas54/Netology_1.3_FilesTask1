package ru.netology.honeybadger;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    private static StringBuilder log = new StringBuilder();
    private static Date dateNow = new Date();

    public static void main(String[] args) {
        File directoryGames = createdInstanceFileDirectory("G://", "Games");
        createdDirectory(directoryGames);
//1.В папке Games создайте несколько директорий: src, res, savegames, temp.
        File directorySRC = createdInstanceFileDirectory(directoryGames.getAbsolutePath(), "src");
        createdDirectory(directorySRC);
        File directoryRES = createdInstanceFileDirectory(directoryGames.getAbsolutePath(), "res");
        createdDirectory(directoryRES);
        File directorySaveGames = createdInstanceFileDirectory(directoryGames.getAbsolutePath(), "savegames");
        createdDirectory(directorySaveGames);
        File directoryTEMP = createdInstanceFileDirectory(directoryGames.getAbsolutePath(), "temp");
        createdDirectory(directoryTEMP);
//2.В каталоге src создайте две директории: main, test.
        File directoryMain = createdInstanceFileDirectory(directorySRC.getAbsolutePath(), "main");
        createdDirectory(directoryMain);
        File directoryTest = createdInstanceFileDirectory(directorySRC.getAbsolutePath(), "test");
        createdDirectory(directoryTest);
//3.В подкаталоге main создайте два файла: Main.java, Utils.java.
        File fileMain = createdInstanceFileDirectory(directoryMain.getAbsolutePath(), "Main.java");
        createdFile(fileMain);
        File fileUtils = createdInstanceFileDirectory(directoryMain.getAbsolutePath(), "Utils.java");
        createdFile(fileUtils);
//4.В каталог res создайте три директории: drawables, vectors, icons.
        File directoryDrawables = createdInstanceFileDirectory(directoryRES.getAbsolutePath(), "drawables");
        createdDirectory(directoryDrawables);
        File directoryVectors = createdInstanceFileDirectory(directoryRES.getAbsolutePath(), "vectors");
        createdDirectory(directoryVectors);
        File directoryIcons = createdInstanceFileDirectory(directoryRES.getAbsolutePath(), "icons");
        createdDirectory(directoryIcons);
//5.В директории temp создайте файл temp.txt.
        File fileTemp = createdInstanceFileDirectory(directoryTEMP.getAbsolutePath(), "temp.txt");
        createdFile(fileTemp);
        try (FileWriter fileWriter = new FileWriter(fileTemp, false)) {
            fileWriter.write(log.toString());
            fileWriter.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println(log);
    }

    private static File createdInstanceFileDirectory(String pathName, String directoryName) {
        File instanceFile = new File(pathName + "/" + directoryName);
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

