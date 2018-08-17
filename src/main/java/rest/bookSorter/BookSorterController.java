package rest.bookSorter;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import rest.bookSorter.holder.BookSorterRequest;
import rest.bookSorter.holder.BookSorterResponse;
import util.exception.OrderingException;


public interface BookSorterController {

    @RequestMapping(value = "/sortBoooks", method = RequestMethod.POST)
    BookSorterResponse sortBoooks(@RequestBody BookSorterRequest request) throws OrderingException;

}
