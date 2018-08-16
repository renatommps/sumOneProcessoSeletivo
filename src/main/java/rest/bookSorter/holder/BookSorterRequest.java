package rest.bookSorter.holder;

import java.io.Serializable;
import java.util.List;

import model.Book;

public class BookSorterRequest implements Serializable {

    private static final long serialVersionUID = 1L;

	private List<Book> books;

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
