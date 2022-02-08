package ru.geekbrains;

import java.util.Arrays;

public class HomeWorkApp {
    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();

        /* Метод run() напрямую выполнять не стоит, так как он выполнит этот метод просто в
            текущем потоке, без запуска нового потока */
        //noinspection CallToThreadRun
        createThread(arr).run();

        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        float[] arr = new float[SIZE];

        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();

        // Создаем два массива для левой и правой части исходного
        float[] leftHalf = new float[HALF];
        float[] rightHalf = new float[HALF];

        // Копируем в них значения из большого массива
        System.arraycopy(arr, 0, leftHalf, 0, HALF);
        System.arraycopy(arr, HALF, rightHalf, 0, HALF);

        // Запускает два потока и параллельно просчитываем каждый малый массив
        createThread(leftHalf).start();
        createThread(rightHalf).start();

        // Склеиваем малые массивы обратно в один большой
        System.arraycopy(leftHalf, 0, arr, 0, HALF);
        System.arraycopy(rightHalf, 0, arr, HALF, HALF);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private static Thread createThread(float[] arr) {
        return new Thread(() -> {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + (float) (i / 5))
                        * Math.cos(0.2f + (float) (i / 5))
                        * Math.cos(0.4f + (float) (i / 2)));
            }
        });
    }
}
