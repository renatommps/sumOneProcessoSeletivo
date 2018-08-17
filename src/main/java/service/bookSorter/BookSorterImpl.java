package service.bookSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Book;
import service.bookSorter.helper.BookComparator;
import service.bookSorter.helper.BookSortingRules;
import service.fileReader.FileReader;
import service.fileReader.FileReaderImpl;
import util.exception.EmptyRulesException;
import util.exception.OrderingException;

@Service("bookSorter")
public class BookSorterImpl implements BookSorter  {

    @Override
    public List<Book> sort(List<Book> books) throws OrderingException, EmptyRulesException {

        FileReader fileReader = new FileReaderImpl();
        List<Book> sortedBooks = books.subList(0, books.size());
        
        String rules = fileReader.readRulesConfigFile();
        if(rules.isEmpty()){
            throw new EmptyRulesException();
        }

        BookSortingRules sortingRules = new BookSortingRules(rules);
        BookComparator bookComparator = new BookComparator(sortingRules);

        Collections.sort(sortedBooks, bookComparator);

        return sortedBooks;
    }
}
