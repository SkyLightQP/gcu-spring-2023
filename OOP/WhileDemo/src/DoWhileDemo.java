import java.util.Scanner;

public class DoWhileDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number:");
        int count = scan.nextInt();

        int i = 0;
        do {
            System.out.print((i + 1) + ", ");
            i++;
        } while (i < count);

        System.out.println("\nBuckle my shoe.");
    }
}
