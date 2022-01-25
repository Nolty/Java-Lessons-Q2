package ru.geekbrains;

import ru.geekbrains.exception.MyArrayDataException;
import ru.geekbrains.exception.MyArraySizeException;

public class HomeWorkApp {
    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sum(arr);
            System.out.println(result);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    private static int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (getArrayLength(arr) != 16) {
            throw new MyArraySizeException("Размер массива не соответствует ожидаему (4х4)!");
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    result += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException exception) {
                    throw new MyArrayDataException(
                            String.format("Не возможно преобразовать зачение %s к Integer, в массиве по адресу [%d][%d]!",
                                    arr[i][j], i, j));
                }
            }
        }

        return result;
    }

    private static int getArrayLength(Object[][] objects) {
        int result = 0;
        for (Object[] object : objects) {
            result += object.length;
        }
        return result;
    }
}
