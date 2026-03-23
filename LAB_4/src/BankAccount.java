import Exceptions.InsufficientFundsException;
import Exceptions.InvalidAmountException;

public class BankAccount {

    private String accountId;
    private String owner;
    private double balance;

    public BankAccount(String accountId, String owner, double initialBalance) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = initialBalance;
    }

    /*
    TODO: Throw InvalidAmountException if amount <= 0.
    Deposits the given amount into this account.
    Depozitează suma dată în contul this.
    */
    public void deposit(double amount) throws InvalidAmountException {
        // TODO: validate amount.
        try {
            if (amount < 0) {
                throw new InvalidAmountException(amount);
            }
            balance += amount;
            System.out.println("Deposited " + amount + " to account " + accountId +
                    ". New balance: " + balance);
        } finally {
            System.out.println("[LOG] Deposit called from: [" + this.accountId + "] account with amount: " + amount + " | name: " + this.owner + "\n");
        }
    }
    /*

    TODO: Throw InvalidAmountException if amount <= 0.
    TODO: Throw InsufficientFundsException if balance < amount.
    Withdraws the given amount from this account.
    Retrage suma dată din acest cont.
    */
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        /*
        TODO: validate amount
        TODO: check balance
         */

        try {
            if (amount < 0) {
                throw new InvalidAmountException(amount);
            }
            if (balance < amount) {
                throw new InsufficientFundsException(balance);
            }
            balance -= amount;
            System.out.println("Withdrew " + amount + " from account " + accountId +
                    ". New balance: " + balance);
        } finally {
            System.out.println("[LOG] There was a try to withdraw: " + amount + " money from: [" + this.accountId + "] account | owner: " + this.owner + "\n");
        }
    }
    /*
    TODO: Throw InvalidAmountException if amount <= 0.
    TODO: Throw InsufficientFundsException if this account's balance < amount.
    Transfers the given amount from this account to the target account.
    Transferă suma dată din acest cont în contul target.
    */
    public void transfer(BankAccount target, double amount) throws InvalidAmountException, InsufficientFundsException {
        // TODO: validate, then withdraw from this and deposit to target
        // TODO_RO: validează, apoi retrage din this și depozitează în target.
        try {
            if (amount <= 0) {
                throw new InvalidAmountException(amount);
            }
            if (balance < amount) {
                throw new InsufficientFundsException(balance);
            }
            this.balance -= amount;
            target.balance += amount;
            System.out.println("Transferred " + amount + " from " + accountId +
                    " to " + target.accountId);
        } finally {
            System.out.println("[LOG] A transfer was initialized by: " + this.accountId + " account to the: " + target.getAccountId()
                    + " account | Owner: " + this.owner + " | Target: " + target.getOwner() + "\n");
        }
    }

    public String getAccountId() { return accountId; }
    public String getOwner()     { return owner; }
    public double getBalance()   { return balance; }

    @Override
    public String toString() {
        return "BankAccount[id=" + accountId + ", owner=" + owner +
                ", balance=" + balance + "]";
    }
}