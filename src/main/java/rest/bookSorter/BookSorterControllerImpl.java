package rest.bookSorter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import model.Book;
import rest.bookSorter.holder.BookSorterRequest;
import rest.bookSorter.holder.BookSorterResponse;
import service.bookSorter.BookSorter;
import service.bookSorter.BookSorterImpl;
import util.exception.EmptyRulesException;
import util.exception.OrderingException;


@RestController
public class BookSorterControllerImpl implements BookSorterController {

    private BookSorter bookSorter;

    public BookSorterControllerImpl(){
        this.bookSorter = new BookSorterImpl();
    }

    @Override
    @RequestMapping(value = "/sortBoooks", method = RequestMethod.POST)
    public BookSorterResponse sortBoooks(@RequestBody BookSorterRequest request) throws OrderingException {
        BookSorterResponse response = new BookSorterResponse();
        try {
            List<Book> books = request.getBooks();
            List<Book> sortedBooks = bookSorter.sort(books);
            response.setBooks(sortedBooks);
            return response;
        } catch (EmptyRulesException e) {
            return response;
        } catch (OrderingException e) {
            throw e;
        } catch (Exception e) {
            throw new OrderingException();
        }
    }

}