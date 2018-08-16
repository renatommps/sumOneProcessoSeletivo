package model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

	private String title;
	private String author;
    private int editionYear;
    
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
    }
    
	/**
	 * @return the editionYear
	 */
	public int getEditionYear() {
		return editionYear;
    }
    
	/**
	 * @param editionYear the editionYear to set
	 */
	public void setEditionYear(int editionYear) {
		this.editionYear = editionYear;
    }
    
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
    }
    
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
    }
    
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
    
}
