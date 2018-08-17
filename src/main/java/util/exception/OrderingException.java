package util.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "OrderingException")
public class OrderingException extends Exception {

	private static final long serialVersionUID = 1L;

	public OrderingException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderingException(String message) {
		super(message);
	}

	public OrderingException(Throwable cause) {
		super(cause);
    }
    
	public OrderingException() {
	}
}
