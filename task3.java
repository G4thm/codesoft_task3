import java.util.Scanner;

class bankaccount {
    private double balance;

    public bankaccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        else {
            return false;
        }

    }
}
class atm {
    public bankaccount account;

    public atm(bankaccount account) {
        this.account = account;
    }

    public void display() {
        System.out.println("                                                                             ATM  MENU");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void checkBalance() {
        System.out.println("Your current balance is: Rs." + account.getBalance());
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful. Your new balance is: Rs." + account.getBalance());
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: Rs.");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Your new balance is: Rs." + account.getBalance());
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            display();
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
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
                    System.out.println("Thank you for choosing us");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice!= 4);
    }
}

public class user {
    public static void main(String[] args) {
        int accountnumber;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Your Account number:");
        accountnumber=scanner.nextInt();
        System.out.println("Enter your password      :");
        int pass=scanner.nextInt();
        System.out.println("Successfully Signed in!");

        bankaccount account = new bankaccount(0); // Initial balance of $1000
        atm atm = new atm(account);
        atm.run();
    }
}