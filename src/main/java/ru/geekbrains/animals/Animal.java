package ru.geekbrains.animals;

import java.util.HashMap;
import java.util.InputMismatchException;

public abstract class Animal {
    protected String color;
    protected Integer age;
    protected String name;

    public static int COUNT = 0;
    private static final HashMap<String, Integer> COUNT_OF_CHILD = new HashMap<>();

    public Animal() {
        COUNT++;
    }

    public Animal(String color, Integer age, String name) {
        this.color = color;
        this.age = age;
        this.name = name;
        COUNT++;
        System.out.println(COUNT);
    }

    public abstract void voice();

    public abstract String preparingToFile();

    public static void addAnimal(Animal animal) {
        Integer count = COUNT_OF_CHILD.get(animal.getClass().getName());
        if(count == null) {
            count = 0;
        }
        COUNT_OF_CHILD.put(animal.getClass().getName(), count + 1);
    }

    public static void getAnimalCount(Animal animal) {
        System.out.println(COUNT_OF_CHILD.get(animal.getClass().getName()));
    }

    public static void print() {
        System.out.println("s");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public final void setAge(Integer age) {
        if (age < 0) {
            throw new InputMismatchException("Возраст не может быть ниже нуля");
        }

        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
