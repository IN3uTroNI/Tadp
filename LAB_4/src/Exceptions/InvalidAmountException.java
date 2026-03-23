package Exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(Number e) {
        super("Invalid Amount: " + e + " !!");
    }
}
