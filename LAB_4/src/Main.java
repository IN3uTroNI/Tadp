import Exceptions.InsufficientFundsException;
import Exceptions.InvalidAmountException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankManager manager = new BankManager();

        BankAccount Nico = new BankAccount("ADWEQ#", "Nico", 1000.9);
        BankAccount Vancea = new BankAccount("AAWDWA", "Vancea", 325.3);

        manager.addAccount(Nico);
        manager.addAccount(Vancea);
        manager.printAllAccounts();

        // Deposit
        System.out.println("Depost valid:");
        try {
            Nico.deposit(200.2);
        } catch (InvalidAmountException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        System.out.println("Depost invalid:");
        try {
            Nico.deposit(-200.2);
        } catch (InvalidAmountException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        // Withdraw
        System.out.println("Withdraw valid:");
        try {
            Nico.withdraw(100.1);
        } catch (InvalidAmountException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        System.out.println("Depost invalid:");
        try {
            Nico.withdraw(20000.5);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        // Transfer
        System.out.println("Transfer valid:");
        try {
            Nico.transfer(Vancea, 213.2);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        System.out.println("Transfer invalid:");
        try {
            Nico.transfer(Vancea, 2231.2);
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        manager.printAllAccounts();
    }
}