package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardFromFile {
    public List<String> readFromFile(String path) {
        List<String> cards = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            boolean start = false;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.equals("End")) {
                    start = false;
                    cards.add(stringBuilder.toString());
                }
                else if (start) stringBuilder.append(line).append("\n");
                else if (line.equals("Start")) {
                    start = true;
                    stringBuilder = new StringBuilder();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return cards;
    }
}
