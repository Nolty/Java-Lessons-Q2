package ru.geekbrains;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.geekbrains.animals.Cat;
import ru.geekbrains.read.AnimalFileReader;
import ru.geekbrains.write.AnimalFileWriter;

public class MainController {

    @FXML
    private TextField ageTextField;

    @FXML
    private TextField colorTextField;

    @FXML
    private TextField jumpHeightTextField;

    @FXML
    private Label mainTextArea;

    @FXML
    private TextField nameTextField;


    private final AnimalFileReader animalFileReader;
    private final AnimalFileWriter animalFileWriter;

    public MainController() {
        this.animalFileReader = new AnimalFileReader();
        this.animalFileWriter = new AnimalFileWriter();
    }

    public void loadAnimals(ActionEvent event) {
        String text = animalFileReader.readFile("animals.txt");
        mainTextArea.setText(text);
    }

    public void saveAnimal(ActionEvent event) {
        Cat cat = new Cat();
        cat.setName(nameTextField.getText());
        cat.setColor(colorTextField.getText());
        cat.setAge(Integer.valueOf(ageTextField.getText()));
        cat.setJumpHeight(jumpHeightTextField.getText());

        animalFileWriter.write("animals.txt", cat);
    }
}