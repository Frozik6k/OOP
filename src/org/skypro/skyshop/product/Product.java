package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return getName();
    }

    @Override
    public String getContent() {
        return "PRODUCT";
    }

}


