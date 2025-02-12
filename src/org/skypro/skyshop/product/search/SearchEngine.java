package org.skypro.skyshop.product.search;

import java.util.*;

public class SearchEngine {

    private Map<String, Searchable> searches = new HashMap<>();

    public Map<String, Searchable> search(String searchText) {

        Map<String, Searchable> result = new TreeMap<>();

        for (Searchable search : searches.values()) {
            if (search.searchTerm().contains(searchText)) {
                result.put(search.searchTerm(), search);
            }

        }

        return result;

    }

    public void add(Searchable searchable) {
        this.searches.put(searchable.searchTerm(), searchable);
    }

    public Searchable foundBestResult(String search) throws BestResultNotFound {
        Searchable result = null;
        int countEntryResult = 0;
        for (Searchable searchable : this.searches.values()) {
            if (searchable != null) {
                int countEntry = 0;
                int index = 0;
                int indexSubString = searchable.searchTerm().indexOf(search, index);
                while (indexSubString != -1) {
                    countEntry++;
                    index = index + search.length();
                    indexSubString = searchable.searchTerm().indexOf(search, index);
                }
                if (countEntryResult < countEntry) result = searchable;
            }
        }
        if (result == null)
            throw new BestResultNotFound("Для поисковой строки \"" + search + "\" не нашлось подходящей строки");
        return result;
    }

}
