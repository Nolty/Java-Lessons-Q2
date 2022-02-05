package ru.geekbrains.animals;

public class AnimalFactory {

    private static final Integer TYPE_OF_ANIMAL_INDEX = 0;
    private static final Integer ANIMAL_NAME_INDEX = 1;
    private static final Integer ANIMAL_COLOR_INDEX = 2;
    private static final Integer ANIMAL_AGE_INDEX = 3;
    private static final Integer CAT_JUMP_HEIGHT_INDEX = 4;

    public static Animal createAnimal(String[] animal) {
        if(animal[TYPE_OF_ANIMAL_INDEX].equals("cat")) {
            return createCat(animal);
        } else {
            throw new RuntimeException("Не смогли создать животное");
        }
    }

    private static Cat createCat(String[] animal) {
        Cat cat = new Cat();
        cat.setName(animal[ANIMAL_NAME_INDEX]);
        cat.setColor(animal[ANIMAL_COLOR_INDEX]);
        cat.setAge(Integer.valueOf(animal[ANIMAL_AGE_INDEX]));
        cat.setJumpHeight(animal[CAT_JUMP_HEIGHT_INDEX]);

        return cat;
    }
}
