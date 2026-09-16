import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Account {

    // adding the Scanner (we add the static to use it everywhere)
    static Scanner scanner = new Scanner(System.in);

    // declaring Feilds
    private String accountNumber;
    private String pin;
    private double BBalanace;

    static double balance = 0;

    // acount intialistion
    public Account(String AccNum, String PIN, Double Balance) {
        this.accounNumber = AccNum; // this grabs what inside so instead of being temporary it gets held
        this.pin = PIN;
        this.BBalance = Balance;
        balance += Balance;
    }

    // history list
    static ArrayList<String> history = new ArrayList<String>();

    static double DailyLimit = 500;

    // deposit without errors
    public static void deposit() {
        System.out.print("Enter the amount: ");
        double amount = scanner.nextInt();
        balance += amount;
        history.add("You've added " + amount + "to your balance");
    }

    // withdraw without errors
    public static void withdraw() {

        Double DailyWithdrawn = 0.0;

        while (true) { // so i can use continue and break

            System.out.print("Enter the amout you want to withdraw");
            Double amount = scanner.nextDouble();

            if (amount >= 0 && amount <= balance && amount + DailyWithdrawn <= DailyLimit) {
                balance -= amount;
                history.add(amount + "was drawn");
            } else if (amount == 0) {
                System.out.println("You cannot withdraw nothing from your balance");
                continue;
            } else if (amount < 0) {
                System.out.println("Please enter a valid amount");
                continue;
            } else if (amount > balance) {
                System.out.println("amount is way more than balance" + "\n Current balance " + balance);
                continue;
            } else if (amount + DailyWithdrawn >= DailyLimit) { // theres somthing wrong with the logic
                System.out.println("You've reached you're daily limit");
                break;
            }
        }
    }

    // interest (i think) this should be runned once per user and since i have one
    // it only gonna be runned once (bad logic but i dont knoe better)
    public static void interest() {
        double amount = balance * 0.02;
        balance += amount;
        history.add("Interest has been added to youre balance by " + amount);
    }

}