import java.util.Scanner;

public class WhileDemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number:");
        int count = scan.nextInt();

        int i = 0;
        while (i < count) {
            if ((i + 1) % 2 != 0) {
                System.out.print((i + 1) + ", ");
            }
            i++;
        }

        System.out.println("\nBuckle my shoe.");
    }
}
