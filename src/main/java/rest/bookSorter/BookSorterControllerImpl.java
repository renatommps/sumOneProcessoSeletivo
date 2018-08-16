package rest.bookSorter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Book;
import rest.bookSorter.holder.BookSorterRequest;
import rest.bookSorter.holder.BookSorterResponse;
import service.bookSorter.BookSorter;
import service.bookSorter.BookSorterImpl;


@RestController
public class BookSorterControllerImpl implements BookSorterController {

    private BookSorter bookSorter;

    public BookSorterControllerImpl(){
        this.bookSorter = new BookSorterImpl();
    }

    @Override
    @RequestMapping(value = "/sortBoooks", method = RequestMethod.POST)
    public BookSorterResponse sortBoooks(@RequestBody BookSorterRequest request) {
        BookSorterResponse response = new BookSorterResponse();
        List<Book> books = request.getBooks();
        List<Book> sortedBooks = bookSorter.sort(books);
        
        response.setBooks(sortedBooks);
        return response;
    }

}