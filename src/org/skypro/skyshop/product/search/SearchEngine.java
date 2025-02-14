package org.skypro.skyshop.product.search;

import java.util.*;

public class SearchEngine {

    private Set<Searchable> searches = new HashSet<>();

    public Set<Searchable> search(String searchText) {

        Set<Searchable> result = new TreeSet<>(new Comparator<Searchable>() {
            @Override
            public int compare(Searchable o1, Searchable o2) {
                if (o1.searchTerm().length() == o2.searchTerm().length()) return o1.searchTerm().compareTo(o2.searchTerm());
                return o2.searchTerm().length() - o1.searchTerm().length();
            }
        });

        for (Searchable search : searches) {
            if (search.searchTerm().contains(searchText)) {
                result.add(search);
            }

        }

        return result;

    }

    public void add(Searchable searchable) {
        this.searches.add(searchable);
    }

    public Searchable foundBestResult(String search) throws BestResultNotFound {
        Searchable result = null;
        int countEntryResult = 0;
        for (Searchable searchable : this.searches) {
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
