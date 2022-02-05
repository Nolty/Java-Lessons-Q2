package ru.geekbrains.animals;

public interface Jumpable {
    default void jump() {
        System.out.println("Я не умею прыгать");
    }
}
