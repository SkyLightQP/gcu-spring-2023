import java.util.Scanner;

/**
 * Homework 2-1
 */

public class Homework_2_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter a line to be checked for profanity");
        String text = scan.nextLine();

        boolean haveProfane = false;
        System.out.println("Your input line");
        haveProfane |= isContainsProfanity(text, "cat");
        haveProfane |= isContainsProfanity(text, "dog");
        haveProfane |= isContainsProfanity(text, "llama");

        if (haveProfane) {
            System.out.println("This line would be considered profane.");
        } else {
            System.out.println("This line would NOT be considered profane.");
        }
    }

    static boolean isContainsProfanity(String checkedText, String word) {
        String lowerCaseText = checkedText.toLowerCase();
        if (lowerCaseText.contains(word)) {
            System.out.println("\tcontains " + word);
            return true;
        } else {
            System.out.println("\tdoes not contain " + word);
        }
        return false;
    }
}
