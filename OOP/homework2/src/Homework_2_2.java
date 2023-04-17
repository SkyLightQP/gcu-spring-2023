import java.util.Scanner;

/**
 *  Homework 2-2
 */

public class Homework_2_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        String[] numbers = input.split(" ");

        int N = numbers.length;
        double max = -1;
        double min = 12345679;
        double sum = 0;
        for (int i = 0; i < N; i++) {
            double number = Double.parseDouble(numbers[i]);
            sum += number;
            if (number > max) max = number;
            if (number < min) min = number;
        }

        double avg = sum / N;
        System.out.println("Highest temperature is " + max);
        System.out.println("Lowest temperature is " + min);
        System.out.println("Average temperature is " + Math.round(avg));
    }
}
