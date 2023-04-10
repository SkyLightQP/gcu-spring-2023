public class PetDemo {
    public static void main(String[] args) {
        System.out.println("My records on your pet are inaccurate.");
        System.out.println("Here is what they currently say:");
        Pet pet = new Pet("A BC");
        pet.writeOutput();

        pet.readInput();

        System.out.println("My updated records now say:");
        pet.writeOutput();
    }
}
