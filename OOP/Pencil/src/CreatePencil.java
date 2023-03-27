public class CreatePencil {
    public static void main(String[] args) {
        Pencil p1 = new Pencil();
        p1.setColor("yellow");
        p1.setPrice(1000);
        p1.printColor();
        p1.printPrice();

        Pencil p2 = new Pencil();
        p2.setColor("green");
        p2.setPrice(900);
        p2.printColor();
        p2.printPrice();
    }
}
