package ru.geekbrains.animals;

public class Dog extends Animal implements Jumpable {

    public Dog() {
    }

    public Dog(String color, Integer age, String name) {
        super(color, age, name);
    }

    @Override
    public void voice() {
        System.out.println("bark");
    }

    @Override
    public String preparingToFile() {
        return null;
    }

    @Override
    public void jump() {
        System.out.println("Собака не умеет прыгать");
    }
}
