import java.util.ArrayList;
import java.util.List;

public class BankManager {

    private List<BankAccount> accounts = new ArrayList<>();

    /*
    Adds a new account to the manager.
    Adaugă un cont nou la manager
     */
    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account registered: " + account.getAccountId());
    }


    /*
    Throw AccountNotFoundException if no account with the given ID exists.
    Finds and returns the account with the given ID.
    */

    /*
    Throw AccountNotFoundException dacă niciun cont cu ID-ul dat nu există.
    Găsește și returnează contul cu ID-ul dat.
    */
    public BankAccount findAccount(String accountId) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountId().equals(accountId)) {
                return acc;
            }
        }
        // TODO: throw AccountNotFoundException instead of returning null.
        // TODO_RO: throw AccountNotFoundException în loc de a returna null.
        return null;
    }

    // Prints all accounts currently registered in the manager.
    // Afișează toate conturile înregistrate în manager.
    public void printAllAccounts() {
        System.out.println("\n--- All Accounts ---");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("--------------------\n");
    }
}