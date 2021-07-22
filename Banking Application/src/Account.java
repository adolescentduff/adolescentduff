import java.util.Scanner;

public class Account {

    // class variables
    int balance;
    int previousTransaction;
    String owner;
    int id;

    // class constructor
    Account(String name, int id) {
        this.owner = name;
        this.id = id;
    }
    // fx for depositing

    void deposit(int amount) {
        if (amount >= 0) {
            this.balance += amount;
            // deposit leaves a positive amount
            previousTransaction = amount;
        }
    }
    void withdraw(int amount) {
        if (!(this.balance - amount <= 0)) {
            this.balance -= amount;
            // withdrawal leaves a negative amount
            previousTransaction = -amount;
        } else {
            System.out.println("Sorry. You have insufficient funds.");
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("You withdrew: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }
    }

    void calculateInterest(int years) {
        double interestRate = 0.185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
    }

    // this is the big boy that asks for user input. I didn't realize a function could ask
    // for user input :<)

    void showMenu() {
        // placeholder variable
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + owner + "!");
        System.out.println("Your ID is: " + id);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // Case A allows for user to check balance
                case 'A':
                    System.out.println("=========================");
                    System.out.println("Balance = $" + this.balance);
                    System.out.println("=========================");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("Enter amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;

                case 'D':


                    System.out.println("=========================");
                    getPreviousTransaction();
                    System.out.println("=========================");
                    System.out.println();
                    break;

                case 'E':

                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println("=========================");
                    break;

                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}


