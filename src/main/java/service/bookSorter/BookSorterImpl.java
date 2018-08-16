package service.bookSorter;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Book;


@Service("bookSorter")
public class BookSorterImpl implements BookSorter  {

    @Override
    public List<Book> sort(List<Book> books){
        List<Book> sortedBooks = books.subList(0, books.size());
        Collections.reverse(sortedBooks);
        return sortedBooks;
    }
}
