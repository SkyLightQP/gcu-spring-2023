public class Swap {
    public static void main(String[] args) {
        IntHolder a = new IntHolder(getRandom()), b = new IntHolder(getRandom());
        System.out.println("a = " + a.value + ", b = " + b.value);
        System.out.println("↓");
        swap(a, b);
        System.out.println("a = " + a.value + ", b = " + b.value);
    }

    static void swap(IntHolder a, IntHolder b) {
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    static int getRandom() {
        return (int) (1 + Math.random() * 10);
    }
}

class IntHolder {
    public int value;
    public IntHolder(int value) {
        this.value = value;
    }
}
