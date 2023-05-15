import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileOutputDemo {
    public static void main(String[] args) {
        String fileName = "out.txt";

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
        } catch (FileNotFoundException ex) {
            System.out.println("Error opening the file " + fileName);
            System.exit(0);
        }

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        writer.println(line);
        writer.close();
    }
}
