import java.io.*;

public class ArrayIODemo {
    public static void main(String[] args) {
        String output = "array.dat";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(output);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            System.out.println("Write objects to " + output);
            Species[] species = new Species[2];
            species[0] = new Species("ABC", 10, 5.5);
            species[1] = new Species("XYZ", 50, 2.3);

            objectOutputStream.writeObject(species);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ex) {
            System.out.println("Error writing to file.");
            System.exit(0);
        }

        System.out.println();

        try {
            FileInputStream fileInputStream = new FileInputStream(output);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            System.out.println("Read objects from " + output);
            Species[] species = (Species[]) objectInputStream.readObject();
            for (int i = 0; i < species.length; i++) {
                System.out.println(species[i]);
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error reading from file.");
            System.exit(0);
        }
    }
}
