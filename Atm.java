import java.util.ArrayList;
import java.util.Scanner;

class ATMSimulation {
    private static double balance = 1000.00; // Initial balance
    private static String pin = "1234"; // Initial PIN
    private static ArrayList<String> transactionHistory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the ATM!");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    balanceInquiry();
                    break;
                case 2:
                    cashWithdrawal();
                    break;
                case 3:
                    cashDeposit();
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void balanceInquiry() {
        System.out.println("Your current balance is: $" + balance);
        transactionHistory.add("Balance Inquiry: $" + balance);
    }

    private static void cashWithdrawal() {
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);
            transactionHistory.add("Withdrawal: $" + amount);
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    private static void cashDeposit() {
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposit successful! New balance: $" + balance);
        transactionHistory.add("Deposit: $" + amount);
    }

    private static void changePin() {
        System.out.print("Enter current PIN: ");
        String currentPin = scanner.next();
        if (currentPin.equals(pin)) {
            System.out.print("Enter new PIN: ");
            String newPin = scanner.next();
            pin = newPin;
            System.out.println("PIN successfully changed.");
            transactionHistory.add("PIN changed");
        } else {
            System.out.println("Incorrect current PIN.");
        }
    }

    private static void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}
