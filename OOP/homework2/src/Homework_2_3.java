import java.util.Scanner;

/**
 * Homework 2-3
 */

public class Homework_2_3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the intercepted message:");
        String message = scan.nextLine();
        System.out.println("Enter the key:");
        int key = scan.nextInt();

        System.out.println("Original message is:");
        for (int i = 0; i < message.length(); i++) {
            int ascii = message.charAt(i);
            int decrypt = ascii - key;
            decrypt %= 127;
            if (decrypt <= 32) decrypt += (127 - 32);

            System.out.print((char) decrypt);
        }
    }
}
