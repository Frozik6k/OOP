package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.search.Searchable;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Article article = (Article) obj;
        return name.contains(article.getName());
    }
}
