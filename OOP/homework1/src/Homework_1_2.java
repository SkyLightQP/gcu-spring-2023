import java.util.Scanner;

/**
 * Homework1-2
 */
public class Homework_1_2 {
    public static final double MONTHLY_INTEREST_RATE = (7.49 / 12) / 100;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter this month's payment (in whole dollars):");
        int payment = scan.nextInt();

        System.out.println("Enter the principal owed (in whole dollars):");
        int principalOwed = scan.nextInt();

        System.out.println("Previous Balance: " + principalOwed);
        System.out.println("Payment: " + payment);

        int interest = (int) (principalOwed * MONTHLY_INTEREST_RATE);
        System.out.println("Interest Paid: " + interest);

        int appliedPrinciple = payment - interest;
        System.out.println("Amount applied to principle: " + appliedPrinciple);
        System.out.println("New Balance: " + (principalOwed - appliedPrinciple));
    }
}
