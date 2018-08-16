package service.bookSorter;

import java.util.List;

import model.Book;


public interface BookSorter  {

    public List<Book> sort(List<Book> books);
}