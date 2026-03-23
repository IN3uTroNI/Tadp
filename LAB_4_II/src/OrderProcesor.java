import Exceptions.*;
import java.util.*;

public class OrderProcesor {

    private List<Product> products;

    public OrderProcesor(List<Product> products) {
        this.products = products;
    }

    public void process(Order order) {
        if (order.getQuantity() <= 0) {
            throw new InvalidOrderException(order.getQuantity());
        }

        Product found = null;

        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(order.getProductName())) {
                found = p;
                break;
            }
        }

        if (found == null) {
            throw new ProductNotFoundException(order.getProductName());
        }

        if (found.getStock() < order.getQuantity()) {
            throw new OutOfStockException(order.getQuantity(), found.getName());
        }

        found.reduceStock(order.getQuantity());
        System.out.println("Comanda procesata pentru " + found.getName());
    }
}