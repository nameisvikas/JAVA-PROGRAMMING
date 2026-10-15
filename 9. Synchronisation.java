class BankAccount {
    String accountNumber, accountHolderName;
    double accountBalance;

    BankAccount(String accNo, String name, double balance) {
        this.accountNumber = accNo;
        this.accountHolderName = name;
        this.accountBalance = balance;
    }

    synchronized void deposit(String userName, double amount) {
        if (amount <= 0) {
            System.out.println(userName + " failed: Invalid deposit (<= 0).");
            return;
        }
        accountBalance += amount;
        System.out.println(userName + " deposited Rs." + amount + " | Updated Balance: Rs." + accountBalance);
    }

    synchronized void withdraw(String userName, double amount) {
        if (amount <= 0) {
            System.out.println(userName + " failed: Invalid withdrawal (<= 0).");
            return;
        }
        if (amount > accountBalance) {
            System.out.println(userName + " failed to withdraw Rs." + amount + " (Insufficient Balance).");
            return;
        }
        accountBalance -= amount;
        System.out.println(userName + " withdrew Rs." + amount + " | Updated Balance: Rs." + accountBalance);
    }

    void displayBalance() {
        System.out.println("\nFinal Balance for " + accountHolderName + " (" + accountNumber + "): Rs." + accountBalance);
    }
}

class UserTransaction extends Thread {
    String userName, transactionType;
    double amount;
    BankAccount acc;

    UserTransaction(String userName, BankAccount acc, String transactionType, double amount) {
        this.userName = userName;
        this.acc = acc;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    @Override
    public void run() {
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        if (transactionType.equalsIgnoreCase("Deposit")) {
            acc.deposit(userName, amount);
        } else {
            acc.withdraw(userName, amount);
        }
    }
}

public class OnlineBankingSystem {
    public static void main(String[] args) throws InterruptedException {
        BankAccount acc = new BankAccount("AC1001", "Rahul", 10000);
        System.out.println("--- Starting Concurrent Transactions | Initial Balance: Rs.10000 ---");

        UserTransaction[] threads = {
            new UserTransaction("User1", acc, "Deposit", 2000),
            new UserTransaction("User2", acc, "Withdrawal", 3000),
            new UserTransaction("User3", acc, "Deposit", 3000),
            new UserTransaction("User4", acc, "Withdrawal", 4000),
            new UserTransaction("User5", acc, "Deposit", 5000),
            new UserTransaction("User6", acc, "Withdrawal", 80000),
            new UserTransaction("User7", acc, "Deposit", -2000),
            new UserTransaction("User8", acc, "Withdrawal", -1000),
            new UserTransaction("User9", acc, "Deposit", 0),
            new UserTransaction("User10", acc, "Withdrawal", 7000),
            new UserTransaction("User11", acc, "Withdrawal", 7000)
        };

        for (UserTransaction t : threads) t.start();
        
        for (UserTransaction t : threads) t.join();

        acc.displayBalance();
    }
}
