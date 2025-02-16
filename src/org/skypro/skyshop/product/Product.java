package org.skypro.skyshop.product;

import org.skypro.skyshop.product.search.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private String name;

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Отсутствует название продукта");
        }
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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return name.contains(product.getName());
    }
}


