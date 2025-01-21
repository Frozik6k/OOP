package org.skypro.skyshop.product.search;

public interface Searchable {

    String searchTerm();

    String getContent();

    default String getStringRepresentation(Searchable searchable){
        return "имя Searchable объекта — тип Searchable-объекта";
    }
}
