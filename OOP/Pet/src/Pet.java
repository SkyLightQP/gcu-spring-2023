import java.util.Scanner;

public class Pet {
    private String name;
    private int age;
    private double weight;

    public Pet() {
        this("EMPTY", 0, 0.0);
    }

    public Pet(String name, int age, double weight) {
        this.setPet(name, age, weight);
    }

    public Pet(String name) {
        this(name, 0, 0.0);
    }

    public Pet(double weight) {
        this("EMPTY", 0, weight);
    }

    public void writeOutput() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age + " years");
        System.out.println("Weight: " + this.weight + " pounds");
    }

    public void readInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the pet name:");
        setName(scan.nextLine());
        System.out.println("Enter the pet age:");
        setAge(scan.nextInt());
        System.out.println("Enter the pet weight:");
        setWeight(scan.nextDouble());
        scan.close();
    }

    public void setPet(String newName, int newAge, double newWeight) {
        this.name = newName;
        if (newAge < 0 || newWeight < 0) {
            System.out.println("ERROR: Negative age or weight.");
            System.exit(0);
        }
        this.age = newAge;
        this.weight = newWeight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("ERROR: Negative age.");
            System.exit(0);
        }
        this.age = age;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            System.out.println("ERROR: Negative weight.");
            System.exit(0);
        }
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }
}
