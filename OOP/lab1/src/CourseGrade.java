import java.util.Scanner;

public class CourseGrade {
    private String subject;
    private int score;
    private int maxScore;

    public CourseGrade(String subject, int maxScore) {
        this.subject = subject;
        this.maxScore = maxScore;
    }

    private int normalizeScore(int maxScore, int inputScore) {
        return (inputScore * 100) / maxScore;
    }

    public void inputScore() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("What is the score of " + this.subject);
            System.out.println("Please enter an integer from 0 to " + this.maxScore);
            int score = scan.nextInt();
            if (score > this.maxScore) {
                System.out.println("Sorry, that score is out of range.");
                continue;
            }
            this.setCurrentScore(normalizeScore(this.maxScore, score));
            this.setMaxScore(100);
            break;
        }
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getCurrentScore() {
        return score;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setCurrentScore(int score) {
        this.score = score;
    }
}
