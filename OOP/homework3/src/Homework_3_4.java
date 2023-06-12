import java.util.Scanner;

public class Homework_3_4 {
    private static final int AMOUNT = 6;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] slots = new String[AMOUNT];
        int cur = 0;

        System.out.println("Welcome to the Appointment scheduler");
        System.out.println("You can schedule an appointment at 1, 2, 3, 4, 5, or 6 PM.");

        while (cur < AMOUNT) {
            String name = "";
            int time;
            try {
                System.out.println("What is your name?");
                name = scan.nextLine();
                System.out.println("When would you like the appointment?");
                time = scan.nextInt();
                scan.nextLine();

                if (time < 1 || time > 6) throw new InvalidTimeException();
                if (slots[time - 1] != null) throw new TimeInUseException();

                slots[time - 1] = name;
                cur++;
            } catch (InvalidTimeException ex) {
                System.out.println("Sorry, that is not a legal time.");
                System.out.println("When would you like the appointment?");
                time = scan.nextInt();
                scan.nextLine();
                slots[time - 1] = name;
                cur++;
            } catch (TimeInUseException ex) {
                System.out.println("This time is already in use.");
                System.out.println("When would you like the appointment?");
                time = scan.nextInt();
                scan.nextLine();
                slots[time - 1] = name;
                cur++;
            }
        }

        System.out.println("All appointments made");
        for (int i = 0; i < AMOUNT; i++) {
            System.out.println("At " + (i + 1) + "PM is " + slots[i]);
        }
    }
}
