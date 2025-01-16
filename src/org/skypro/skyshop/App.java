package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        //Добавление продукта в корзину.
        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("Носки", 100));
        productBasket.addProduct(new DiscountedProduct("Носки", 100, 10));
        productBasket.addProduct(new FixPriceProduct("Книга"));
        productBasket.addProduct(new FixPriceProduct("Кофта"));
        productBasket.addProduct(new DiscountedProduct("Брюки", 500, 30));

        //Печать содержимого корзины с несколькими товарами.
        productBasket.printProducts();

        //Получение стоимости корзины с несколькими товарами.
        System.out.println("Стоимость всех товаров" + productBasket.getTotalPrice());

        //Поиск товара, который есть в корзине.
        if (productBasket.isCheckProduct("Носки")) System.out.println("Товар Носки есть в корзине");
        else System.out.println("Товара Носки нет в корзине");

        //Поиск товара, которого нет в корзине.
        if (productBasket.isCheckProduct("Телевизор")) System.out.println("Товар Телевизор есть в корзине");
        else System.out.println("Товара Телевизор нет в корзине");

        System.out.println(productBasket);

        //Очистка корзины.
        productBasket.clean();

        //Печать содержимого пустой корзины.
        productBasket.printProducts();

        //Получение стоимости пустой корзины.
        System.out.println("Стоимость пустой корзины: " + productBasket.getTotalPrice());

        //Поиск товара по имени в пустой корзине.
        if (productBasket.isCheckProduct("Игрушка")) System.out.println("Товар Игрушка есть в корзине");
        else System.out.println("Товара Игрушка нет в корзине");


    }
}