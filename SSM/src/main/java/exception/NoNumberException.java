package exception;

/**
 * ��治���쳣
 */
public class NoNumberException extends RuntimeException{

	public NoNumberException(String message) {
		super(message);
	}
	
	public NoNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
