public class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Sneha", "SB1002", 15000.0);
        account.displayBalance();
        account.deposit(3000.0);
        account.withdraw(5000.0);
        account.withdraw(12000.0);
        account.displayBalance();
    }
}

class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Withdrawal failed: insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Remaining balance: " + balance);
        }
    }

    public void displayBalance() {
        System.out.println("Bank Account Summary:");
        System.out.println("Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
