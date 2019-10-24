package interfaceUsuario;

public class InterfaceException extends Exception{
	public InterfaceException() {
		super();
	}

	public InterfaceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InterfaceException(String message, Throwable cause) {
		super(message, cause);
	}

	public InterfaceException(String message) {
		super(message);
	}

	public InterfaceException(Throwable cause) {
		super(cause);
	}
}
