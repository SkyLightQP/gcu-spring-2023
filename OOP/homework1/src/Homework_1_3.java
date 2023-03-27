import java.util.Scanner;

/**
 * Homework1-3
 */
public class Homework_1_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter price of item (from 25 cents to a dollar, in 5-cent increments)");
        int price = scan.nextInt();
        price = 100 - price;

        System.out.println("You bought an item for " + price + " cents and gave me a dollar, so your change is");
        int quarters = price / 25;
        price %= 25;
        int dimes = price / 10;
        price %= 10;
        int nickel = price / 5;
        System.out.println(quarters + " quarters, " + dimes + " dimes, and " + nickel + " nickel.");

    }
}
