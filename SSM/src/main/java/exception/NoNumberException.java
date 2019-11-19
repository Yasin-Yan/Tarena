package exception;

/**
 * ¿â´æ²»×ãÒì³£
 */
public class NoNumberException extends RuntimeException{

	public NoNumberException(String message) {
		super(message);
	}
	
	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
