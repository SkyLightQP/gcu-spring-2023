import java.util.Scanner;

/**
 * StudentRecord class for Homework 2-6
 */

public class StudentRecord {
    private final double FINALEXAM_RATE = 0.5;
    private final double MIDTERM_RATE = 0.25;
    private final double QUIZ_RATE = 0.25;

    private int quiz1 = 0;
    private int quiz2 = 0;
    private int midTerm = 0;
    private int finalTerm = 0;
    private double totalScore = -1;
    private char finalLetterGrade = 'F';

    public void inputData() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the first quiz score:");
        setQuiz1(scan.nextInt());
        System.out.println("Enter the second quiz score:");
        setQuiz2(scan.nextInt());

        System.out.println("Enter the midterm exam score:");
        setMidTerm(scan.nextInt());

        System.out.println("Enter the finalterm exam score:");
        setFinalTerm(scan.nextInt());

        scan.close();
    }

    public void outputData() {
        System.out.println("Your first quiz score is " + this.quiz1);
        System.out.println("Your second quiz score is " + this.quiz2);
        System.out.println("Your Midterm exam score is " + this.midTerm);
        System.out.println("Your Finalterm exam score is " + this.finalTerm);
        System.out.println("Your total score is " + this.totalScore);
        System.out.println("Your final letter grade is " + this.finalLetterGrade);
    }

    private double getAverageOfQuiz() {
        int normalizedQuiz1 = this.quiz1 * 10;
        int normalizedQuiz2 = this.quiz2 * 10;
        return (normalizedQuiz1 + normalizedQuiz2) / 2.0;
    }

    public void calculateTotalScore() {
        double quizWeight = getAverageOfQuiz() * QUIZ_RATE;
        double midtermWeight = midTerm * MIDTERM_RATE;
        double finaltermWeight = finalTerm * FINALEXAM_RATE;

        setTotalScore(quizWeight + midtermWeight + finaltermWeight);
    }

    public void calculateFinalLetterGrade() {
        if (totalScore < 0) {
            System.out.println("ERROR: Please execute calculateTotalScore() method before using it.");
            System.exit(0);
            return;
        }

        if (totalScore >= 90) setFinalLetterGrade('A');
        else if (totalScore >= 80) setFinalLetterGrade('B');
        else if (totalScore >= 70) setFinalLetterGrade('C');
        else if (totalScore >= 60) setFinalLetterGrade('D');
        else setFinalLetterGrade('F');
    }

    public int getQuiz1() {
        return quiz1;
    }

    public int getQuiz2() {
        return quiz2;
    }

    public int getMidTerm() {
        return midTerm;
    }

    public int getFinalTerm() {
        return finalTerm;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public char getFinalLetterGrade() {
        return finalLetterGrade;
    }

    public void setQuiz1(int quiz1) {
        if (quiz1 > 10) {
            System.out.println("ERROR: quiz scores can NOT be greater than 10.");
            System.exit(0);
            return;
        }
        this.quiz1 = quiz1;
    }

    public void setQuiz2(int quiz2) {
        if (quiz2 > 10) {
            System.out.println("ERROR: quiz scores can NOT be greater than 10.");
            System.exit(0);
            return;
        }
        this.quiz2 = quiz2;
    }

    public void setMidTerm(int midTerm) {
        if (midTerm > 100) {
            System.out.println("ERROR: Midterm exam score can NOT be greater than 100.");
            System.exit(0);
            return;
        }
        this.midTerm = midTerm;
    }

    public void setFinalTerm(int finalTerm) {
        if (finalTerm > 100) {
            System.out.println("ERROR: Finalterm exam score can NOT be greater than 100.");
            System.exit(0);
            return;
        }
        this.finalTerm = finalTerm;
    }

    public void setTotalScore(double totalScore) {
        if (finalTerm > 100.0) {
            System.out.println("ERROR: Total score can NOT be greater than 100.");
            System.exit(0);
            return;
        }
        this.totalScore = totalScore;
    }

    public void setFinalLetterGrade(char finalLetterGrade) {
        this.finalLetterGrade = finalLetterGrade;
    }
}
