package org.skypro.skyshop.product.search;

public class SearchEngine {

    private int indexSearchable = 0;

    private final Searchable[] searches;

    public SearchEngine(int i) {
        this.searches = new Searchable[i];
    }

    public Searchable[] search(String searchText){
        Searchable[] result = new Searchable[5];
        int index = 0;
        for (Searchable search : this.searches){
            if (search != null && search.searchTerm().contains(searchText)){
                result[index] = search;
                index+=1;
            }
            if (index == result.length) break;
        }
        return result;
    }

    public void add(Searchable searchable){
        this.searches[indexSearchable] = searchable;
        indexSearchable+=1;
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
