package org.skypro.skyshop.product;

public class Product {

    private String name;

    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Продукт: " + name + ", цена: " + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Product)) return false;
        Product product = (Product) obj;
        return (product.name.equals(this.name) && product.price == price);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, price);
    }
}
