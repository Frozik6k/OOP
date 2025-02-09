package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.article.Article;
import org.skypro.skyshop.product.search.BestResultNotFound;
import org.skypro.skyshop.product.search.SearchEngine;
import org.skypro.skyshop.product.search.Searchable;

import java.util.Arrays;

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

        // Добавляем товары и статьи в класс для последующего поиска
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Носки", 100));
        searchEngine.add(new DiscountedProduct("Носки", 100, 10));
        searchEngine.add(new FixPriceProduct("Кофта"));
        searchEngine.add(new FixPriceProduct("Носки"));
        searchEngine.add(new Article("Носки", "Спортивные носки"));
        searchEngine.add(new Article("Кофта", "Самая лучшая кофточка"));
        searchEngine.add(new Article("Носки", "Спортивные носки"));

        // Осуществляем несколько поисков и вывод результатов
        System.out.println(Arrays.toString(searchEngine.search("Телевизор")));
        System.out.println(Arrays.toString(searchEngine.search("Носки")));
        System.out.println(Arrays.toString(searchEngine.search("Кофта")));

        // Тестируем ввод не правильных данных
        try {
            new SimpleProduct(null, 10);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new SimpleProduct("   ", 40);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new SimpleProduct("Смартфон", 0);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new DiscountedProduct("Ноутбук", -1, 23);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new DiscountedProduct("Мотоцикл", 200000, -1);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        try {
            new DiscountedProduct("Клавиатура", 5000, 101);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

        searchEngine.add(new Article("Компьютеры", "Слово компьютер является производным" +
                "от английских слов to compute, computer, которые переводятся как «вычислять», «вычислитель» " +
                "(английское слово, в свою очередь, происходит от латинского computāre — «вычислять»). Первоначально в " +
                "английском языке это слово означало человека, производящего арифметические вычисления с привлечением или без " +
                "привлечения механических устройств. В дальнейшем его значение было перенесено на сами машины, однако современные компьютеры выполняют множество задач, не связанных напрямую с математикой.")
        );

        try {
            System.out.println(searchEngine.foundBestResult("компьютер").searchTerm());
            System.out.println(searchEngine.foundBestResult("Кукарача").searchTerm());
        } catch (BestResultNotFound exception){
            System.out.println(exception.getMessage());
        }

    }
}