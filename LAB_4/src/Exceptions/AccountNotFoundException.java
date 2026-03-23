package Exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super("We are sorry, but the " + message + " account was not found");
    }
}
