package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class CardToFile {
    public void toFile(String card, String fileName, boolean append) {
        try(FileWriter fileWriter = new FileWriter(fileName, append)) {
            fileWriter.write("Start\n" + card + "" + "End\n\n");

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
