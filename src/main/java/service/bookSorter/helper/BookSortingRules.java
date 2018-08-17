package service.bookSorter.helper;

import java.util.ArrayList;

import java.util.List;


public class BookSortingRules {

    private List<String[]> sortingRules;

    public BookSortingRules(String rules) {
        this.sortingRules = new ArrayList<>();

        for(String attribute : rules.split(",")) {
            String[] pairs = attribute.trim().split(":");
            sortingRules.add(pairs);
        }
    }

    public List<String[]> getRules() {
        return sortingRules;
    }

}
