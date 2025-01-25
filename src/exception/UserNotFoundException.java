package exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("Пользователь не найден");

    }
    public UserNotFoundException(String message) {
        super(message);

    }
}
