package SirNaveenTask;

class TransferException extends Exception {
    public TransferException(String message) {
        super(message);
    }
}

class Account {
    int balance;

    Account(int b) {
        this.balance = b;
    }

    Account() {
        this.balance = 200;
    }

    public void transfer(int amount, Account a) throws TransferException {
        if (amount <= this.balance && amount > 0) {
            a.balance += amount;
            this.balance -= amount;
        } else {
            throw new TransferException("Plz enter a right amount");
        }
    }

    public void bulkTransferTo(int amount, Account[] a) throws TransferException {
        if (amount <= this.balance && amount > 0) {
            int div = (int)((double) amount / a.length); // avoids truncation errors
            for (int i = 0; i < a.length; i++) {
                a[i].balance += div;
            }
            this.balance -= div * a.length;
        } else {
            throw new TransferException("Plz enter a right amount");
        }
    }

    public int checkBalance() {
        return this.balance;
    }
}

public class Tasklab1 {
    public static void main(String[] args) {
        Account c1 = new Account(2000);
        Account c2 = new Account(200);

        try {
            System.out.println("C1 Balance Before Transfer: " + c1.checkBalance());
            System.out.println("C2 Balance Before Transfer: " + c2.checkBalance());
            c1.transfer(200, c2);
            System.out.println("Transfer successful!");
            System.out.println("C1 Balance After Transfer: " + c1.checkBalance());
            System.out.println("C2 Balance After Transfer: " + c2.checkBalance());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Bulk Transfer Money:");
        try {
            Account[] accounts = { new Account(), new Account(), new Account() };
            c1.bulkTransferTo(300, accounts);
            System.out.println("Bulk transfer successful!");
            for (int i = 0; i < accounts.length; i++) {
                System.out.println("Account " + (i+1) + " Balance: " + accounts[i].checkBalance());
            }
            System.out.println("C1 Balance After Bulk Transfer: " + c1.checkBalance());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
