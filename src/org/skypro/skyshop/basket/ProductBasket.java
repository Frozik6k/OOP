package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;

public class ProductBasket {
    private Product[] products = new Product[5];

    public ProductBasket(){ }
    public ProductBasket(Product product){
        if (product != null)
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null){
                    products[i] = product;
                    return;
                }
            }
    }

    public void add(Product product){
        if (product != null)
            for (int i = 0; i < products.length; i++) {
                if (products[i] == null){
                    products[i] = product;
                    return;
                }
            }
        System.out.println("Невозможно добавить продукт");
    }

    public int allPrice(){
        int result = 0;
        for(Product product : products){
            if (product != null) result = result + product.getPrice();
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        boolean isCheck = false;
        for(Product product : products){
            if (product != null){
                result = result + product.getName() + ": " + product.getPrice() + "\n";
                isCheck = true;
            }

        }

        if (isCheck) result = result + "Итого: " + allPrice();
        else result = "в корзине пусто";

        return result;
    }

    public boolean isCheckProduct(String nameProduct){
        for (Product product : products){
            if (product != null)
                if (product.getName().equals(nameProduct)) return true;
        }
        return false;
    }

    public void clean(){
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(products);
    }


}
