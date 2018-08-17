package util.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(code = HttpStatus.OK, reason = "EmptyRulesException")
public class EmptyRulesException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyRulesException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyRulesException(String message) {
		super(message);
	}

	public EmptyRulesException(Throwable cause) {
		super(cause);
    }
    
	public EmptyRulesException() {
	}
}
