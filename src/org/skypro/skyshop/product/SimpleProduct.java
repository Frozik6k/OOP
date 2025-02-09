package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String name, int price) {
        super(name);
        if (price < 1) throw new IllegalArgumentException("Цена не может быть меньше единицы");
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
