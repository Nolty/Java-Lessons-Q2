package ru.geekbrains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PhoneBook {
    private final HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        HashSet<String> phones = phoneBook.get(name);
        if (phones != null) {
            phones.add(phoneNumber);
            return;
        }

        phones = new HashSet<>();
        phones.add(phoneNumber);
        phoneBook.put(name, phones);
    }

    public List<String> get(String name) {
        HashSet<String> phoneList = phoneBook.get(name);
        if (phoneList == null) {
            return null;
        }

        return new ArrayList<>(phoneList);
    }
}
