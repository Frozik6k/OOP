package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductBasket {
    private Product[] products = new Product[5];

    public ProductBasket() {
    }

    public void addProduct(Product product) {
        if (product != null)
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null) {
                    products[i] = product;
                    return;
                }
            }
        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalPrice() {
        int result = 0;
        for (Product product : products) {
            if (product != null) result = result + product.getPrice();
        }
        return result;
    }

    public void printProducts() {
        String result = "";
        boolean isCheck = false;
        for (Product product : products) {
            if (product != null) {
                result = result + product.getName() + ": " + product.getPrice() + "\n";
                isCheck = true;
            }

        }

        if (isCheck) result = result + "Итого: " + getTotalPrice();
        else result = "в корзине пусто";

        System.out.println(result);;
    }

    public boolean isCheckProduct(String nameProduct) {
        for (Product product : products) {
            if (product != null)
                if (product.getName().equals(nameProduct)) return true;
        }
        return false;
    }

    public void clean() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(products);
    }


    @Override
    public String toString() {
        String result = "";
        for( Product product : products){
            if (product != null) result+=product+"\n";
        }
        return result;
    }
}
