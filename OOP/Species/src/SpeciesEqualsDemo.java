public class SpeciesEqualsDemo {
    public static void main(String[] args) {
        Species s = new Species();
        s.setSpecies("A", 1000, 50);

        Species s2 = new Species();
        s2.setSpecies("B", 1302, 40.3);

        Species s3 = new Species();
        s3.setSpecies("A", 1000, 50);

        System.out.println("s.equals(s2): " + s.equals(s2));
        System.out.println("s.equals(s3): " + s.equals(s3));
        System.out.println("s == s3: " + (s == s3));
    }
}
