import java.util.Scanner;

/**
 * Homework1-5
 */
public class Homework_1_5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a date (month/day/year): ");
        String date = scan.nextLine();
        String[] splitedDate = date.split("/");
        String month = splitedDate[0];
        String day = splitedDate[1];
        String year = splitedDate[2];

        System.out.println("Result: " + day + "." + month + "." + year + ".");

    }
}
