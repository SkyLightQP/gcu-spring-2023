import java.util.Scanner;

public class ForInput {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int product = 1;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Please enter a new number (" + i + " of 10):");
            int input = scan.nextInt();
            product *= input;
        }

        System.out.println("Total product is: " + product);
    }
}