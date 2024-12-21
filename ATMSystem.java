import java.util.Scanner;

public class ATMSystem {

    // BankAccount class to represent the user's bank account
    static class BankAccount {
        private double balance;

        // Constructor to initialize the balance
        public BankAccount(double initialBalance) {
            if (initialBalance > 0) {
                balance = initialBalance;
            } else {
                balance = 0;
            }
        }

        // Method to deposit money into the account
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Deposit amount should be positive.");
            }
        }

        // Method to withdraw money from the account
        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            } else {
                System.out.println("Insufficient funds or invalid withdrawal amount.");
                return false;
            }
        }

        // Method to check the balance
        public double getBalance() {
            return balance;
        }
    }

    // ATM class with methods to interact with the user
    static class ATM {
        private BankAccount account;
        private Scanner scanner;

        // Constructor to initialize the ATM with a bank account
        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        // Method to display the menu and handle user options
        public void displayMenu() {
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Please choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

        // Method to check the balance
        private void checkBalance() {
            System.out.println("Your current balance is: ₹" + account.getBalance());
        }

        // Method to deposit money
        private void deposit() {
            System.out.print("Enter deposit amount: ₹");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposited ₹" + amount + " successfully.");
        }

        // Method to withdraw money
        private void withdraw() {
            System.out.print("Enter withdrawal amount: ₹");
            double amount = scanner.nextDouble();
            boolean success = account.withdraw(amount);
            if (success) {
                System.out.println("Withdrawn ₹" + amount + " successfully.");
            }
        }
    }

    // Main method to run the ATM system
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount myAccount = new BankAccount(10000.0);

        // Create an ATM instance and connect it to the user's bank account
        ATM atm = new ATM(myAccount);

        // Start the ATM system
        atm.displayMenu();
    }
}
