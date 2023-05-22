import java.io.*;
import java.util.Scanner;

public class BinaryOutputDemo {
    public static void main(String[] args) throws IOException {
        String fileName = "./numbers.dat";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the non-negative integer value: ");
        while (true) {
            int value = scan.nextInt();
            objectOutputStream.writeInt(value);
            if (value < 0) break;
        }

        System.out.println("Written to the file " + fileName);

        objectOutputStream.close();
        fileOutputStream.close();

        System.out.println();
        readBinaryFile(fileName);
    }

    public static void readBinaryFile(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        System.out.println("Read the non-negative integer value in the " + fileName);
        try {
            while (true) {
                int value = objectInputStream.readInt();
                if (value < 0) break;
                System.out.println("Read value: " + value);
            }
        } catch (EOFException e) {
            System.out.println("End Of File.");
        }

        objectInputStream.close();
        fileInputStream.close();
    }
}
