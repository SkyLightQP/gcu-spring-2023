import java.util.Scanner;

public class Scholarships {
    private int scholarshipAmt;

    private double scholarshipPercent;

    private int firstScholarship;

    private int secondScholarship;

    public Scholarships() {
    }

    public double getFirstScholarship() {
        return firstScholarship;
    }

    public double getSecondScholarship() {
        return secondScholarship;
    }

    public int getScholarshipAmt() {
        return scholarshipAmt;
    }

    public void registerScholarships() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter total scholarship amount.");
        this.scholarshipAmt = scan.nextInt();
        System.out.println("Enter the percentage(%) of scholarship to be given to the first student.");
        this.scholarshipPercent = scan.nextDouble();

        this.firstScholarship = (int) (this.scholarshipAmt * (this.scholarshipPercent / 100));
        this.secondScholarship = this.scholarshipAmt - this.firstScholarship;
    }

    public void writeOutput() {
        System.out.println("Total amount of scholarship given is : " + this.scholarshipAmt);
        System.out.println("1st scholarship amount is : " + this.firstScholarship);
        System.out.println("2nd scholarship amount is : " + this.secondScholarship);
    }
}
