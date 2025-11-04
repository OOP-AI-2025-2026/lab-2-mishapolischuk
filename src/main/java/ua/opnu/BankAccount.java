package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    public BankAccount() {

    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
        }

    }

    public double getBalance() {
        return this.balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            return false;
        }
        double totalWithdrawal = amount + transactionFee;
        if (balance >= totalWithdrawal) {
            balance = balance - totalWithdrawal;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0 || receiver == null) {
            return false;
        }

        double totalCost = amount + this.transactionFee;
        if (this.balance >= totalCost) {
            this.balance -= totalCost;
            receiver.balance += amount;
            return true;
        }

        return false;
    }
}