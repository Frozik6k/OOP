package org.skypro.skyshop.product.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Searchable> searches = new ArrayList<>();

    public List<Searchable> search(String searchText){

        List<Searchable> result = new ArrayList<>();

        for (Searchable search : this.searches){
            if (search.searchTerm().contains(searchText)){
                result.add(search);
            }

        }

        return result;

    }

    public void add(Searchable searchable){
        this.searches.add(searchable);
    }

    public Searchable foundBestResult(String search) throws BestResultNotFound {
        Searchable result = null;
        int countEntryResult = 0;
        for (Searchable searchable : this.searches){
            if (searchable != null){
                int countEntry = 0;
                int index = 0;
                int indexSubString = searchable.searchTerm().indexOf(search, index);
                while (indexSubString != -1){
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
