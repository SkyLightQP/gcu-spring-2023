import java.util.Scanner;

public class ExamAverager {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Want to average another exam?");
            System.out.println("Enter yes or no.");
            String confirm = scan.nextLine();
            if (!(confirm.equalsIgnoreCase("yes"))) break;

            System.out.println("Enter all the scores to be averaged.");
            System.out.println("Enter a negative number after");
            System.out.println("you have entered all the scores.");

            double scoreSum = 0.0;
            int scoreCnt = 0;
            int answer;
            do {
                answer = scan.nextInt();
                if (answer >= 0) {
                    scoreSum += answer;
                    scoreCnt++;
                }
            } while (answer != -1);

            System.out.println("The average is " + (scoreSum / scoreCnt) + "\n");

            scan.nextLine();
        }
    }
}
