public class Pencil {
    public String color = "white";
    public int length;
    public float diameter;
    private float price;
    public static long nextID = 0L;

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void printPrice() {
        System.out.println("Price is " + this.price);
    }

    public void printColor() {
        System.out.println("Color is " + this.color);
    }
}


