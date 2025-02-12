package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> products = new TreeMap<>();

    public ProductBasket() {
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalPrice() {
        int result = 0;
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                result = result + product.getPrice();
            }
        }
        return result;
    }

    public void printProducts() {

        String result = "";
        boolean isCheck = false;

        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                result = result + product.getName() + ": " + product.getPrice() + "\n";
                isCheck = true;
            }
        }


        if (isCheck) result = result + "Итого: " + getTotalPrice();
        else result = "в корзине пусто";

        System.out.println(result);
        ;
    }

    public boolean isCheckProduct(String nameProduct) {
        return (products.containsKey(nameProduct));
    }

    public List<Product> removeNameProducts(String nameProduct) {

        List<Product> result = new ArrayList<>();

        if (products.containsKey(nameProduct)) {
            result = new ArrayList<>(products.get(nameProduct));
            products.remove(nameProduct);
        }

        return result;
    }

    public void clean() {
        products.clear();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(products);
    }


    @Override
    public String toString() {
        String result = "";
        for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
            for (Product product : entry.getValue()) {
                result += product + "\n";
            }
        }

        return result;
    }
}
