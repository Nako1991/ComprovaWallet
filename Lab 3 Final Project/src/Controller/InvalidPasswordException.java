package Controller;

public class InvalidPasswordException extends Exception {

    public InvalidPasswordException(String mesagge) {
        super(mesagge);
    }
}
