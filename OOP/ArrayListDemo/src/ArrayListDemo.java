import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter items for the list, when prompted");

        while (true) {
            System.out.println("Type an entry: ");
            String entry = scan.nextLine();
            list.add(entry);

            System.out.println("More items for the list?");
            String answer = scan.nextLine();
            if (!answer.equalsIgnoreCase("yes")) break;
        }

        System.out.println("\nThe list contains:");
        list.forEach(System.out::println);

        scan.close();
    }
}
