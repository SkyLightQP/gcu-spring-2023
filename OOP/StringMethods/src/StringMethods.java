public class StringMethods {
    public static void main(String[] args) {
        String greetings = "hello";
        String greetings2 = new String("HELLO");
        String greetings3;
        greetings3 = "Hello";

        System.out.println(greetings + " / " + greetings2 + " / " + greetings3);
        System.out.println("Length of greetings: " + greetings.length());

        System.out.println("charAt(0): " + greetings.charAt(0));
        System.out.println("greetings.compareTo(greetings2): " + greetings.compareTo(greetings2));
        System.out.println("greetings.concat(greetings2): " + greetings.concat(greetings2));
        System.out.println("greetings.equals(greetings2): " + greetings.equals(greetings2));
        System.out.println("greetings.equalsIgnoreCase(greetings2): " + greetings.equalsIgnoreCase(greetings2));
        System.out.println("greetings.indexOf(\"llo\"): " + greetings.indexOf("llo"));

        String date = "2018-03-12";
        System.out.println("date.indexOf(\"-\"): " + date.indexOf("-"));
        System.out.println("date.lastIndexOf(\"-\"): " + date.lastIndexOf("-"));

        System.out.println("greetings.toUpperCase(): " + greetings.toUpperCase());
        System.out.println("greetings.substring(0, 1).toUpperCase(): " + greetings.substring(0, 1).toUpperCase());
        System.out.println("greetings.substring(0, 3): " + greetings.substring(0, 3));
        System.out.println("greetings.substring(1): " + greetings.substring(1));

        String textWithBlank = "    hello     ";
        System.out.println("textWithBlank.trim(): " + textWithBlank.trim());
    }
}
