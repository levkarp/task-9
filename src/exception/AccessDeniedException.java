package exception;

public class AccessDeniedException extends Exception{
    public AccessDeniedException(String message) {
        super(message);
    }
    public AccessDeniedException() {
        super("Доступ запрещён, обратитесь к админстратору");

    }

}
