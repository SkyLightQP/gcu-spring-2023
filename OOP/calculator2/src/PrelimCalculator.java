import java.util.Scanner;

public class PrelimCalculator {
    private double result;
    private static final double precision = 0.0001;

    public static void main(String[] args) {
        PrelimCalculator cal = new PrelimCalculator();

        System.out.println("Calculator is on.");
        System.out.println("Format of each line: operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the letter e.");

        try {
            cal.doCalculation();
        } catch (UnknownOpException e) {
            System.out.println(e.getMessage());
        } catch (DivideByZeroException e2) {
            System.out.println(e2.getMessage());
        }

        System.out.println("The final result is " + cal.getResult());
        System.out.println("Calculator program ending.");
    }

    public PrelimCalculator() {
        result = 0;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void reset() {
        result = 0;
    }

    public void doCalculation() throws UnknownOpException, DivideByZeroException {
        Scanner scan = new Scanner(System.in);
        System.out.println("result = " + result);
        while (true) {
            char op = scan.next().charAt(0);
            if (op == 'e' || op == 'E') break;
            double number = scan.nextDouble();
            double res = evaluate(op, result, number);
            setResult(res);
            System.out.println("result " + op + " " + number + " = " + result);
            System.out.println("updated result = " + result);
        }
    }

    public double evaluate(char op, double num1, double num2) throws UnknownOpException, DivideByZeroException {
        if (op == '+') {
            return num1 + num2;
        } else if (op == '-') {
            return num1 - num2;
        } else if (op == '*') {
            return num1 * num2;
        } else if (op == '/') {
            if ((num2 > -precision) && (num2 < precision)) {
                throw new DivideByZeroException();
            }
            return num1 / num2;
        } else {
            throw new UnknownOpException(op);
        }
    }
}
