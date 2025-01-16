package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int baseprice;
    private int discount;

    public DiscountedProduct(String name, int baseprice) {
        super(name);
        this.baseprice = baseprice;
        this.discount = 0;
    }

    public DiscountedProduct(String name, int baseprice, int discount) {
        super(name);
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
