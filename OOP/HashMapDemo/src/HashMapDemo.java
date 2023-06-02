import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, Integer> mountains = new HashMap<>();

        mountains.put("Everest", 29029);
        mountains.put("K2", 28251);
        mountains.put("Kangchenjunga", 28169);
        mountains.put("Denali", 20335);
        printMap(mountains);
        System.out.println("\nDenali in the map: " + mountains.containsKey("Denali"));
        System.out.println("\nChanging height of Denali.");
        mountains.put("Denali", 20320);
        printMap(mountains);
        System.out.println("\nRemoving Kangchenjunga");
        mountains.remove("Kangchenjunga");
        printMap(mountains);
    }

    static void printMap(HashMap<String, Integer> map) {
        System.out.println("Map contains: ");
        for (String name : map.keySet()) {
            System.out.println(name + ": " + map.get(name) + " feet.");
        }
    }
}
