package ru.geekbrains.person.seller;

import ru.geekbrains.person.Person;
import ru.geekbrains.person.customer.Customer;
import ru.geekbrains.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Seller extends Person {
    private final String name;
    private final String lastName;
    private List<Product> products;

    public Seller(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.products = new ArrayList<>();
    }

    public Seller(String name, String lastName, long cash) {
        this(name, lastName);
        this.setCash(cash);
    }

    public boolean sellProduct(Customer customer, Product expectedProduct) {
        for (Product product : products) {
            // Проверяем по имени товара что у продавца есть продукт
            if (product.getName().equals(expectedProduct.getName())) {
                // Проверяем что количество товара >= чем мы хотим купить
                if (product.getQuantity() >= expectedProduct.getQuantity()) {
                    // Проверяем что кэш покупателя позволяет купить товар
                    long requiredCash = (long) product.getPrice() * expectedProduct.getQuantity();
                    if (customer.getCash() >= requiredCash) {
                        // Уменьшаем количество продукта у продавца
                        product.setQuantity(product.getQuantity() - expectedProduct.getQuantity());
                        //Увеличиваем кэш продавца
                        setCash(getCash() + requiredCash);

                        //Добавляем количество продуктов у покупателя
                        customer.addPurchase(new Product(
                                expectedProduct.getName(),
                                expectedProduct.getQuantity(),
                                product.getPrice()
                        ));
                        //Уменьшаем кэш покупателя
                        customer.setCash(customer.getCash() - requiredCash);
                        //Сообщаем потребителю метода, что покупка совершена

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Product> getProducts() {
        if (products == null) {
            return null;
        }

        return new ArrayList<>(products);
    }

    public void setProducts(List<Product> products) {
        if (products != null) {
            this.products = new ArrayList<>(products);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller seller)) return false;

        if (getName() != null ? !getName().equals(seller.getName()) : seller.getName() != null) return false;
        return getLastName() != null ? getLastName().equals(seller.getLastName()) : seller.getLastName() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        return result;
    }

    public boolean equalsNameAndLastName(String name, String lastName) {
        return this.name.equals(name) && this.lastName.equals(lastName);
    }

}
