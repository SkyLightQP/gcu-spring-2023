import java.util.Scanner;

public class CircleCalculation2 {
    public static final double PI = 3.141592;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the radius of a circle in inches:");
        double radius = scan.nextDouble();

        System.out.println("A Circle of radius " + radius + " inches");
        System.out.println("has an area of " + PI * radius * radius + " square inches.");
    }
}
