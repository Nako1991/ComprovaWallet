package Exceptions;

public class InvalidUserDoesntExists extends Exception {
    public InvalidUserDoesntExists(String message) {
        super(message);
    }
}
