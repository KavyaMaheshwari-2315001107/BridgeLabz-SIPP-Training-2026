public class BankAccountScenario {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("AC101", "Neeraj", 5000.0);
        BankAccount account2 = new BankAccount("AC102", "Priya", 10000.0);
        BankAccount account3 = new BankAccount("AC103", "Raman", 7500.0);

        account1.deposit(2000.0);
        account1.withdraw(1000.0);
        account1.deposit(500.0);
        account1.withdraw(7000.0);
        account1.withdraw(200.0);

        account2.deposit(1000.0);
        account2.withdraw(800.0);
        account2.deposit(200.0);
        account2.withdraw(5000.0);
        account2.withdraw(6000.0);

        account3.deposit(2500.0);
        account3.withdraw(4000.0);
        account3.deposit(1500.0);
        account3.withdraw(200.0);
        account3.withdraw(1000.0);

        account1.getStatement();
        account2.getStatement();
        account3.getStatement();
        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}

class BankAccount {
    private final String accountNumber;
    private String holder;
    private double balance;
    private int transactions;
    private static int totalAccounts = 0;

    public BankAccount(String accountNumber, String holder, double balance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = balance;
        this.transactions = 0;
        totalAccounts++;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions++;
            System.out.println(holder + " deposited " + amount + ". New balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println(holder + " cannot withdraw " + amount + ". Insufficient balance.");
        } else {
            balance -= amount;
            transactions++;
            System.out.println(holder + " withdrew " + amount + ". New balance: " + balance);
        }
    }

    public void getStatement() {
        System.out.println("\nAccount Statement for " + holder + ":");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Final balance: " + balance);
        System.out.println("Total transactions: " + transactions);
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
