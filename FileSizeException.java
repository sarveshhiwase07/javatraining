package eh.exceptions;

public class FileSizeException extends Exception {
	private static final long serialVersionUID = -7885648364091150548L;

	public FileSizeException(String msg){
		super(msg);
	}
}
