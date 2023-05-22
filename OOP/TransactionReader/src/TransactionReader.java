import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TransactionReader {
    public static void main(String[] args) throws IOException {
        File file = new File("./test.csv");
        Scanner input = new Scanner(file);
        double total = 0;

        while (input.hasNextLine()) {
            String inputLine = input.nextLine();
            String[] item = inputLine.split(",");
            StringTokenizer token = new StringTokenizer(inputLine, ",");
            System.out.println(token.nextToken());

            System.out.println("SKU: " + item[0] + ", Quantity: " + item[1] + ", Price: " + item[2] + ", Description: " + item[3]);
            total += Integer.parseInt(item[1]) * Double.parseDouble(item[2]);
        }

        System.out.printf("Total sales: %1.2f\n", total);

        input.close();
    }
}
