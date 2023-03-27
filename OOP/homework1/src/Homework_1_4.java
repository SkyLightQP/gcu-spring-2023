import java.util.Scanner;

/**
 * Homework1-4
 */
public class Homework_1_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the four-bit binary number:");
        String bit = scan.nextLine();

        String[] eachBit = bit.split("");
        int result = 0;
        if (eachBit[0].equals("1")) result += 8;
        if (eachBit[1].equals("1")) result += 4;
        if (eachBit[2].equals("1")) result += 2;
        if (eachBit[3].equals("1")) result += 1;
        System.out.println("Result: " + result);
    }
}
