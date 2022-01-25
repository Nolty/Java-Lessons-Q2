package ru.geekbrains.exception;

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException() {
    }

    public MyArraySizeException(String message) {
        super(message);
    }
}
