package ru.geekbrains;

import ru.geekbrains.market.Market;
import ru.geekbrains.person.customer.Customer;
import ru.geekbrains.person.seller.Seller;
import ru.geekbrains.product.Product;

import java.util.List;

import static ru.geekbrains.MarketConstants.CUCUMBER_PRODUCT_NAME;
import static ru.geekbrains.MarketConstants.TOMATOES_PRODUCT_NAME;

public class HomeWorkApp {

    public static void main(String[] args) {
        Market market = new Market();

        Seller firstSeller = createFirstSeller();
        Seller secondSeller = createSecondSeller();

        market.addSeller(firstSeller);
        market.addSeller(secondSeller);

        Customer customer = createFirstCustomer();
        // customer.buyProductOnMarket(market);
        customer.buyProductBySeller(market, firstSeller);
        customer.info();
    }

    private static Customer createFirstCustomer() {
        return new Customer(List.of(
                new Product(TOMATOES_PRODUCT_NAME, 3),
                new Product(CUCUMBER_PRODUCT_NAME, 2)
        ), 50);
    }

    private static Seller createFirstSeller() {
        Seller seller = new Seller("Виталий", "Еремин", 0);
        seller.setProducts(List.of(
                new Product(TOMATOES_PRODUCT_NAME, 2, 10),
                new Product(CUCUMBER_PRODUCT_NAME, 100, 8)
        ));

        return seller;
    }

    private static Seller createSecondSeller() {
        Seller seller = new Seller("Алексей", "Ушаков", 0);
        seller.setProducts(List.of(
                new Product(TOMATOES_PRODUCT_NAME, 40, 8),
                new Product(CUCUMBER_PRODUCT_NAME, 12, 5)
        ));

        return seller;
    }
}
