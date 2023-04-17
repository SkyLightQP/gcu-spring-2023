public class Wrapper {
    public static void main(String[] args) {
        Double avg = new Double("3.145");
        System.out.println(avg);

        Integer I = Integer.valueOf("10");
        System.out.println(I);
        Double D = Double.valueOf("10.0");
        System.out.println(D);
        Boolean B = Boolean.valueOf("true");
        System.out.println(B);
        Character C = Character.valueOf('a');
        System.out.println(C);

        Integer I1 = Integer.valueOf("1111", 2);
        System.out.println(I1);

        System.out.println(I.byteValue());
        System.out.println(I.shortValue());
        System.out.println(I.intValue());
        System.out.println(I.longValue());
        System.out.println(I.floatValue());
        System.out.println(I.doubleValue());

        int i = Integer.parseInt("10");
        double d = Double.parseDouble("10.5");
        boolean b = Boolean.parseBoolean("true");
        System.out.println(i);
        System.out.println(d);
        System.out.println(b);

        String s = I.toString();
        System.out.println(s);
        String s1 = Integer.toString(15, 2);
        System.out.println(s1);

        Integer age1 = new Integer(30);
        Integer age2 = 30;
        Integer age3 = 30;

        System.out.println(age1);
        System.out.println(age1.intValue());

        System.out.println(age2);
        System.out.println(age2.intValue());

        if (age1 == age2) {
            System.out.println("Reference same");
        }

        if (age2 == age3) {
            System.out.println("Reference same");
        }

        if (age1.intValue() == age2.intValue()) {
            System.out.println("Value same");
        }
    }
}
