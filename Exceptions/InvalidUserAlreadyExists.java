package Exceptions;

public class InvalidUserAlreadyExists extends Exception {
    public InvalidUserAlreadyExists(String message) {
        super(message);
    }
}
