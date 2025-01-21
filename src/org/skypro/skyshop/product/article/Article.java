package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.search.Searchable;

public class Article implements Searchable {
    
    private final String name;
    
    private final String text;

    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return name + "\n" + text;
    }

    @Override
    public String searchTerm() {
        return toString();
    }

    @Override
    public String getContent() {
        return "ARTICLE";
    }

}
