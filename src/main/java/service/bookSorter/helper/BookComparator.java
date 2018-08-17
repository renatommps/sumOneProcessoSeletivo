package service.bookSorter.helper;

import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import model.Book;


public class BookComparator implements Comparator<Book>{

    private final String DEFAULT_DIRECTION = "ascending";

    private BookSortingRules sortingRules;

    public BookComparator(BookSortingRules sortingRules) {
        this.sortingRules = sortingRules;
	}

    @Override
	public int compare(Book bookA, Book bookB) {
        CompareToBuilder compareToBuilder = new CompareToBuilder();

        sortingRules.getRules().forEach(rulePair -> {
            String ruleName = rulePair[0].trim().toLowerCase();
            String roleOrder = rulePair[1].trim();

            switch (ruleName) {
                case "title":
                    if (roleOrder.equalsIgnoreCase(DEFAULT_DIRECTION)) {
                        compareToBuilder.append(bookA.getTitle(), bookB.getTitle());
                    } else {
                        compareToBuilder.append(bookB.getTitle(), bookA.getTitle());
                    }
                    break;
                case "author":
                    if (roleOrder.equalsIgnoreCase(DEFAULT_DIRECTION)) {
                        compareToBuilder.append(bookA.getAuthor(), bookB.getAuthor());
                    } else {
                        compareToBuilder.append(bookB.getAuthor(), bookA.getAuthor());
                    }
                    break;
                case "editionYear":
                    if (roleOrder.equalsIgnoreCase(DEFAULT_DIRECTION)) {
                        compareToBuilder.append(bookA.getEditionYear(), bookB.getEditionYear());
                    } else {
                        compareToBuilder.append(bookB.getEditionYear(), bookA.getEditionYear());
                    }
                    break;
                default:
                    break;
            }
        });

        return compareToBuilder.toComparison();
    }
}