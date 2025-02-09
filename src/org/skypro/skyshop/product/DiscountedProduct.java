package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int baseprice;
    private int discount;

    public DiscountedProduct(String name, int baseprice) {
        super(name);
        if (baseprice < 1) throw new IllegalArgumentException("Цена не может быть меньше единицы");
        this.baseprice = baseprice;
        this.discount = 0;
    }

    public DiscountedProduct(String name, int baseprice, int discount) {
        super(name);
        if (baseprice < 1) throw new IllegalArgumentException("Цена не может быть меньше единицы");
        if (discount < 0) throw new IllegalArgumentException("Скидка не может быть меньше 0");
        if (discount > 100) throw new IllegalArgumentException("Скидка не может быть больше 100");
        this.baseprice = baseprice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return this.baseprice - (this.baseprice * this.discount);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + baseprice + " (" + discount + "%)";
    }
}
