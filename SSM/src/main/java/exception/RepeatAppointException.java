package exception;
/**
 * �ظ�ԤԼ�쳣
 */
public class RepeatAppointException extends RuntimeException{
	public RepeatAppointException(String message) {
		super(message);
	}
	
	public RepeatAppointException(String message, Throwable cause) {
		super(message, cause);
	}
}
