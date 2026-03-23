package Exceptions;

public class ProductNotFoundException extends ShopException {
    public ProductNotFoundException(String prod) {
        super("Produsul: " + prod + " nu a fost gasit\n");
    }
}
