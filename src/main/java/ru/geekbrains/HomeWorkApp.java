package ru.geekbrains;

import java.util.HashMap;

public class HomeWorkApp {
    public static void main(String[] args) {
        getUniqueList();
        findPhoneNumber();
    }

    private static void getUniqueList() {
        String[] arr = {"1", "2", "3", "2", "1", "5", "2", "6", "3", "4", "8", "9", "2", "5", "3", "6", "3", "6", "2", "4"};
        HashMap<String, Integer> result = new HashMap<>();

        for(String key: arr) {
            Integer value;
            if ((value = result.get(key)) != null) {
                result.put(key, ++value);
            } else {
                result.put(key, 0);
            }
        }

        result.forEach((key, value) -> System.out.printf("value: %s; count: %d\n", key, value));
    }

    private static void findPhoneNumber() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Enrichetta", "495-639-0058");
        phoneBook.add("Sheelah", "774-931-3294");
        phoneBook.add("Licha", "407-992-2697");
        phoneBook.add("Neala", "305-711-1921");
        phoneBook.add("Sheelah", "396-390-7056");
        phoneBook.add("Elane", "896-920-1239");

        System.out.println(phoneBook.get("Sheelah"));
        System.out.println(phoneBook.get("Elane"));
        System.out.println(phoneBook.get("Elanes"));
    }
}
