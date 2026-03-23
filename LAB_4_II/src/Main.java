import Exceptions.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 3000, 5));
        products.add(new Product("Mouse", 100, 10));
        products.add(new Product("Keyboard", 200, 0));

        OrderProcesor processor = new OrderProcesor(products);

        List<Order> orders = List.of(
                new Order("Laptop", 2),      // valid
                new Order("Mouse", 0),       // invalid
                new Order("Keyboard", 1),    // out of stock
                new Order("Monitor", 1),     // not found
                new Order("Laptop", 10),     // out of stock
                new Order("Mouse", 3)        // valid
        );

        int valid = 0;
        int invalid = 0;

        List<String> errors = new ArrayList<>();

        for (Order o : orders) {
            try {
                processor.process(o);
                valid++;
            } catch (OutOfStockException e) {
                invalid++;
                System.out.println(e.getMessage());
                System.out.println("Sugestie: Restocati produsul.\n");
                errors.add(e.getMessage());
            } catch (InvalidOrderException e) {
                invalid++;
                System.out.println("Eroare comanda: " + e.getMessage() + "\n");
                errors.add(e.getMessage());
            } catch (ProductNotFoundException e) {
                invalid++;
                System.out.println(e.getMessage() + "\n");
                errors.add(e.getMessage());
            } finally {
                System.out.println("[ERROR] Please fix!");
            }
        }
        System.out.println("\n");
        System.out.println("Comenzi valide: " + valid);
        System.out.println("Comenzi invalide: " + invalid);

        System.out.println("\nMotive erori:");
        for (String err : errors) {
            System.out.println(" = " + err);
        }
    }
}