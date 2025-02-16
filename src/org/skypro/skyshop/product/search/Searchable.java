package org.skypro.skyshop.product.search;

import java.util.Comparator;

public interface Searchable {

    String searchTerm();

    String getContent();

    default String getStringRepresentation(Searchable searchable) {
        return "имя Searchable объекта — тип Searchable-объекта";
    }

}
