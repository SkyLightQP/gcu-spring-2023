import java.util.Scanner;

public class MultipleThrows {
    public static void main(String[] args) {
        try {
            Scanner keyboard = new Scanner(System.in);

            System.out.println("Enter number of widgets produced:");

            int widgets = keyboard.nextInt();
            if (widgets < 0) throw new NegativeNumberException("widgets");
            System.out.println("How many were defective?");

            int defective = keyboard.nextInt();
            if (defective < 0) throw new NegativeNumberException("defective widgets");

            double ratio = exceptionalDivision(widgets, defective);
            System.out.println("One in every " + ratio + " widgets is defective.");
        } catch (NegativeNumberException e) {
            System.out.println("ERROR: The " + e.getMessage() + " value is negative.");
            System.exit(0);
        } catch (DivideByZeroException e) {
            System.out.println("ERROR: Can not divide by zero.");
            System.exit(0);
        }

        System.out.println("End of program.");
    }

    public static double exceptionalDivision(double numerator, double denominator) throws DivideByZeroException {
        if (denominator == 0) throw new DivideByZeroException();
        return numerator / denominator;
    }

}
