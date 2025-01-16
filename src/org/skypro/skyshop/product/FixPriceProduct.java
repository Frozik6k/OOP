package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int fixPrice = 399;
    public FixPriceProduct(String name){
        super(name);
    }
    @Override
    public int getPrice() {
        return this.fixPrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }
}
