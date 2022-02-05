package ru.geekbrains.read;

import ru.geekbrains.animals.Animal;
import ru.geekbrains.animals.AnimalFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AnimalFileReader {
    public String readFile(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String s;
            StringBuilder result = new StringBuilder();
            while ((s = reader.readLine()) != null) {
                Animal animal = AnimalFactory.createAnimal(s.split(","));
                result.append(animal).append("\n");
            }

            return result.toString();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return "";
    }
}
