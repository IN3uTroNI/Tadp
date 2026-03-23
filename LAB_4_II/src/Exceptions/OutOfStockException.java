package Exceptions;

public class OutOfStockException extends ShopException {
    public OutOfStockException(Number amount, String prod) {
        super("Stoc insuficient pentru comanda de: " + amount + " de " + prod + "\n");
    }
}
