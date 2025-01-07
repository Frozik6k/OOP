package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        //Добавление продукта в корзину.
        ProductBasket productBasket = new ProductBasket();
        productBasket.add(new Product("Носки", 100));

        //Добавление продукта в заполненную корзину, в которой нет свободного места.
        for (int i = 0; i < 5; i++) {
            productBasket.add(new Product("Гвозди", 10));
        }

        //Печать содержимого корзины с несколькими товарами.
        System.out.println(productBasket.toString());

        //Получение стоимости корзины с несколькими товарами.
        System.out.println("Стоимость всех товаров" + productBasket.allPrice());

        //Поиск товара, который есть в корзине.
        if (productBasket.isCheckProduct("Носки")) System.out.println("Товар Носки есть в корзине");
        else System.out.println("Товара Носки нет в корзине");

        //Поиск товара, которого нет в корзине.
        if (productBasket.isCheckProduct("Телевизор")) System.out.println("Товар Телевизор есть в корзине");
        else System.out.println("Товара Телевизор нет в корзине");

        //Очистка корзины.
        productBasket.clean();

        //Печать содержимого пустой корзины.
        System.out.println(productBasket.toString());

        //Получение стоимости пустой корзины.
        System.out.println("Стоимость пустой корзины: " + productBasket.allPrice());

        //Поиск товара по имени в пустой корзине.
        if (productBasket.isCheckProduct("Игрушка")) System.out.println("Товар Игрушка есть в корзине");
        else System.out.println("Товара Игрушка нет в корзине");



    }
}