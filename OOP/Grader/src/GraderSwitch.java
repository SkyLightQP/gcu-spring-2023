import java.util.Scanner;

public class GraderSwitch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int score;
        char grade;

        System.out.println("Enter your score:");
        score = scan.nextInt();

        int dividedScore = score / 10;
        switch (dividedScore) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }

        System.out.println("Score = " + score);
        System.out.println("Grade = " + grade);

        String text = grade == 'A' ? "잘했어" : "열심히 해";
        System.out.println(text);
    }
}
