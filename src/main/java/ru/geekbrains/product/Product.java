package ru.geekbrains.product;

public class Product implements Cloneable {
    private final String name;
    private int price;
    private int quantity;

    public Product(String name) {
        this.name = name;
        this.price = 0;
        this.quantity = 0;
    }

    public Product(String name, int quantity) {
        this(name);
        this.quantity = quantity;
    }

    public Product(String name, int quantity, int price) {
        this(name, quantity);
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;

        return getName().equals(product.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public String toString() {
        return "Product {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
