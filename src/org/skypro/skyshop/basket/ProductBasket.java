package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> products = new LinkedList<>();

    public ProductBasket() {
    }

    public void addProduct(Product product) {
        products.add(product);
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

    public List<Product> removeNameProducts(String nameProduct) {

        List<Product> listRemoveProducts = new LinkedList<>();

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product product = iterator.next();
            if (product.getName().contains(nameProduct)){
                listRemoveProducts.add(product);
                iterator.remove();
            }
        }

        return listRemoveProducts;
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
        for( Product product : products){
            if (product != null) result+=product+"\n";
        }
        return result;
    }
}
