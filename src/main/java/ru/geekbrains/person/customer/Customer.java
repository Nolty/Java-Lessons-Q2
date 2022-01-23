package ru.geekbrains.person.customer;

import ru.geekbrains.market.Market;
import ru.geekbrains.person.Person;
import ru.geekbrains.person.seller.Seller;
import ru.geekbrains.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private final List<Product> expectedPurchaseList;
    private List<Product> purchaseList;

    public Customer(List<Product> expectedPurchaseList, int cash) {
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = new ArrayList<>(expectedPurchaseList);
        this.setCash(cash);
    }

    public void addPurchase(Product product) {
        purchaseList.add(product);
    }

    private void buyProduct(List<Product> productList, List<Seller> sellerList) {
        for (Product product : productList) {
            for (Seller seller : sellerList) {
                boolean isBought = seller.sellProduct(this, product);
                if (isBought) {
                    break;
                }
            }
        }
    }

    public void buyProductOnMarket(Market market) {
        buyProduct(expectedPurchaseList, market.getSellers());
    }

    public void buyProductBySeller(Market market, Seller seller) {
        List<Product> productList = new ArrayList<>();
        List<Seller> sellerList = new ArrayList<>();

        for (Seller currentSeller : market.getSellers()) {
            if (currentSeller.equalsNameAndLastName(seller.getName(), seller.getLastName())) {
                for (Product product : expectedPurchaseList) {
                    boolean isBought = seller.sellProduct(this, product);
                    if (!isBought) {
                        productList.add(product);
                    }
                }
            } else {
                sellerList.add(currentSeller);
            }
        }

        if (sellerList.size() > 0 && productList.size() > 0) {
            buyProduct(productList, sellerList);
        }
    }

    public void info() {
        StringBuilder result = new StringBuilder();
        if (purchaseList.size() == 0) {
            result.append("Я ничего не купил.");
        } else {
            result.append("Я купил:");
            long summa = 0;
            for (Product product : purchaseList) {
                result.append("\n");
                result.append(product.getName());
                result.append(" ");
                result.append(product.getQuantity());
                result.append(" шт.");
                result.append(" за ");
                result.append(product.getPrice());
                result.append(" руб.");
                summa += (long) product.getQuantity() * product.getPrice();
            }
            result.append("\nИтого я потратил ");
            result.append(summa);
            result.append(" руб.");
        }

        result.append("\nИ у меня осталось ");
        result.append(getCash());
        result.append(" рублей");

        System.out.println(result);
    }

    public List<Product> getExpectedPurchaseList() {
        return new ArrayList<>(expectedPurchaseList);
    }

    public List<Product> getPurchaseList() {
        return new ArrayList<>(purchaseList);
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = new ArrayList<>(purchaseList);
    }

}
