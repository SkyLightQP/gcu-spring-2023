import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter two whole numbers");
        System.out.println("separated by one or more spaces:");
        String number1 = scan.next();
        String number2 = scan.next();
        System.out.println("You entered " + number1 + " and " + number2);
        System.out.println();

        System.out.println("Next enter two numbers.");
        System.out.println("A decimal point is OK.");
        String decimal1 = scan.next();
        String decimal2 = scan.next();
        System.out.println("You entered " + decimal1 + " and " + decimal2);
        System.out.println();

        System.out.println("Next enter two words:");
        String word1 = scan.next();
        String word2 = scan.next();
        System.out.println("You entered \"" + word1 + "\" and \"" + word2 + "\"");
        System.out.println();

        scan.nextLine();
        System.out.println("Next enter a line of text:");
        String text = scan.nextLine();
        System.out.println("You entered \"" + text + "\"");
    }
}
