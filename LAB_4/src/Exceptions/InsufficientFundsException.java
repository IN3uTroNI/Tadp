package Exceptions;

public class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(Number e) {
        super("We are sorry to announce. You do not have enough money!!\n" +
                "Amount: " + e);
    }
}
