package ru.geekbrains.market;

import ru.geekbrains.person.seller.Seller;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private final List<Seller> sellers;

    public Market() {
        this.sellers = new ArrayList<>();
    }

    public List<Seller> getSellers() {
        return List.copyOf(sellers);
    }

    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    public Seller getSeller(String name, String lastName) {
        for (Seller seller : sellers) {
            if (seller.equalsNameAndLastName(name, lastName)) {
                return seller;
            }
        }

        return null;
    }
}
