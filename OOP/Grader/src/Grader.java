import java.util.Scanner;

public class Grader {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int score;
        char grade;

        System.out.println("Enter your score:");
        score = scan.nextInt();

        if (score >= 90) grade = 'A';
        else if (score >= 80) grade = 'B';
        else if (score >= 70) grade = 'C';
        else if (score >= 60) grade = 'D';
        else grade = 'F';

        System.out.println("Score = " + score);
        System.out.println("Grade = " + grade);

        String text = grade == 'A' ? "잘했어" : "열심히 해";
        System.out.println(text);
    }
}
