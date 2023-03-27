import java.util.Scanner;

/**
 * Homework1-1
 */
public class Homework_1_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // (a)
        System.out.println("Enter a text: ");
        String str = scan.nextLine();
        int lastWordIndex = str.lastIndexOf(' ');
        String result = str.substring(lastWordIndex + 1);
        System.out.println("(a) The last word is " + result);

        // (b)
        String temp = str.replace(str.substring(lastWordIndex), "");
        int secondLastWordIndex = temp.lastIndexOf(' ');
        String result2 = temp.substring(secondLastWordIndex + 1);
        System.out.println("(b) The second last word is " + result2);
    }
}
