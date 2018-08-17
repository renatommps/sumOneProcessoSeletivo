package service.bookSorter;

import java.util.List;

import model.Book;
import util.exception.EmptyRulesException;
import util.exception.OrderingException;


public interface BookSorter  {

    public List<Book> sort(List<Book> books) throws OrderingException, EmptyRulesException;
}