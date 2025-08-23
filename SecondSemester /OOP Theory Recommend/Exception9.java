// Custom Exception Class
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message); // Must be first in constructor
    }
}

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Amount is more than balance");
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining Balance: " + balance);
    }
}

// Main Class
public class Exception9 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0); // Initial balance

        try {
            account.withdraw(600); // Try to withdraw more than balance
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        try {
            account.withdraw(200); // Valid withdrawal
        } catch (InsufficientBalanceException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

