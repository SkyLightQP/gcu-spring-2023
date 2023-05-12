import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Read data 1");

        int numInt2 = System.in.read();
        System.in.skip(2);
        System.out.println((char) numInt2);

        byte[] data = new byte[100];
        System.out.println("Read data 2");
        System.in.read(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print((char) data[i]);
        }

        System.out.println("\n");

        InputStreamReader is = new InputStreamReader(System.in);
        OutputStreamWriter os = new OutputStreamWriter(System.out);

        int readint = is.read();
        os.write((char) readint);

        is.close();
        os.close();
    }
}
