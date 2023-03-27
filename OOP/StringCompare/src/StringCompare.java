public class StringCompare {
    public static void main(String[] args) {
        String a = "Hello";
        String b = "hello";
        String c = "hello";
        String d = new String("Hello");

        if (a == b) System.out.println("true");
        else System.out.println("false");

        if (a == c) System.out.println("true");
        else System.out.println("false");

        if (b == c) System.out.println("true");
        else System.out.println("false");

        if (a == d) System.out.println("true");
        else System.out.println("false");

        System.out.println();

        if (a.equals(d)) System.out.println("true");
        else System.out.println("false");

        if (b.equals(d)) System.out.println("true");
        else System.out.println("false");

        if (b.equalsIgnoreCase(d)) System.out.println("true");
        else System.out.println("false");
    }
}
