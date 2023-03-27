import java.util.Scanner;

public class EggBasket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int egg, basket;

        System.out.println("Input egg: ");
        egg = scan.nextInt();

        System.out.println("Input basket: ");
        basket = scan.nextInt();

        int total = egg * basket;

        System.out.println("\nif you have");
        System.out.println(egg + " eggs per basket and");
        System.out.println(basket + " baskets, then");
        System.out.println("the total number of eggs is " + total);

        System.out.println();
        boolean bool = true;
        System.out.println("bool: " + bool);
        String item = "egg";
        System.out.println("item: " + item);
    }
}
