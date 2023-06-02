import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(2);
        set.add(7);
        set.add(7);
        set.add(3);
        printSet(set);
        set.remove(3);
        printSet(set);

        System.out.println("Set contains 2: " + set.contains(2));
        System.out.println("Set contains 3: " + set.contains(3));
    }

    static void printSet(HashSet<Integer> set) {
        System.out.println("The set contains:");
        set.forEach(System.out::println);
    }
}
