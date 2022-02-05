package ru.geekbrains.animals;

public class Cat extends Animal implements Jumpable {
    private String jumpHeight;

    public static int CAT_COUNT = 0;

    public Cat() {
        super();
    }

    public Cat(String color, Integer age, String name) {
        this.color = color;
        this.age = age;
        this.name = name;
        CAT_COUNT++;
    }

    public static void print() {
        Animal.print();
    }

    @Override
    public void voice() {
        System.out.println("meow");
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    protected Cat clone() {
        Cat cat = new Cat();
        cat.age = this.age;
        cat.name = this.name;
        cat.color = this.color;

        return cat;
    }

    public String getJumpHeight() {
        return jumpHeight;
    }

    public void setJumpHeight(String jumpHeight) {
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void jump() {
        System.out.println("Кот умеет прыгать на 160м");
    }

    @Override
    public String toString() {
        return "Кот" + ": " + getName() + ", Цвет: " + getColor() + ", Возраст: " + getAge() + ", Высота прыжка: " + jumpHeight;
    }

    @Override
    public String preparingToFile() {
        return "cat" + "," + getName() + "," + getColor() + "," + getAge() + "," + getJumpHeight();
    }
}
