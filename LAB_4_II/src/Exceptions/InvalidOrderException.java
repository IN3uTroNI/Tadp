package Exceptions;

public class InvalidOrderException extends ShopException {
    public InvalidOrderException(Number e) {
        super("Comanda invalida | Comanda: " + e + "\n");
    }
}
