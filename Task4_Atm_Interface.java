import java.util.Scanner;

class BankAccount {
    private double balance;



    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. Current balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }
}


class ATM {
    private final BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void menu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, Scanner sc) {
        switch (choice) {
            case 1 -> System.out.println("Current balance: $" + bankAccount.getBalance());
            case 2 -> {
                System.out.print("Enter deposit amount: $");
                double depositAmount = sc.nextDouble();
                bankAccount.deposit(depositAmount);
            }
            case 3 -> {
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = sc.nextDouble();
                bankAccount.withdraw(withdrawalAmount);
            }
            case 4 -> {
                System.out.println("Exiting ATM. Thank you!");
                sc.close();
                System.exit(0);
            }
            default -> System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}
public class Task4_Atm_Interface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial account balance: $");
        double initialBalance = sc.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.menu();
            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            atm.performTransaction(choice, sc);
        }
    }
}
