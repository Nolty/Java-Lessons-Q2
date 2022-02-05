package ru.geekbrains.write;

import ru.geekbrains.animals.Animal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AnimalFileWriter {
    public void write(String fileName, Animal animal) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write(animal.preparingToFile() + "\n");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
