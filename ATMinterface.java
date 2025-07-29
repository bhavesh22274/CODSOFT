#codsoft
import java.util.Scanner;

public class ATM {

    static class BankAccount {
        private double balance;

        public BankAccount(double startingAmount) {
            this.balance = startingAmount;
        }

        public double checkBalance() {
            return this.balance;
        }

        public void depositMoney(double amount) {
            if (amount > 0) {
                this.balance = this.balance + amount;
                System.out.println("Successfully deposited $" + amount);
            } else {
                System.out.println("You have to deposit a positive amount.");
            }
        }

        public boolean withdrawMoney(double amount) {
            if (amount > this.balance) {
                System.out.println("Error: Not enough money in the account.");
                return false;
            } else if (amount <= 0) {
                System.out.println("Error: Must withdraw a positive amount.");
                return false;
            } else {
                this.balance = this.balance - amount;
                System.out.println("Successfully withdrew $" + amount);
                return true;
            }
        }
    }

    public static void main(String[] args) {

        BankAccount userAccount = new BankAccount(500.00);
        Scanner keyboard = new Scanner(System.in);

        while (true) {

            System.out.println("\nWelcome to the ATM!");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("What would you like to do? (Enter a number): ");

            int choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: $" + userAccount.checkBalance());
                    break;

                case 2:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = keyboard.nextDouble();
                    userAccount.depositMoney(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = keyboard.nextDouble();
                    userAccount.withdrawMoney(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    keyboard.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
