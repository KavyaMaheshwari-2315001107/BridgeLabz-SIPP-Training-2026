public class BankAccountManagement {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount("AC2001", "Kavya", 18000.0);
        account.displayAccountDetails();
        account.deposit(2500.0);
        account.withdraw(8000.0);
    }
}

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
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
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Remaining balance: " + balance);
        } else {
            System.out.println("Withdrawal failed: insufficient funds or invalid amount.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void deposit(double amount) {
        super.deposit(amount);
    }

    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
