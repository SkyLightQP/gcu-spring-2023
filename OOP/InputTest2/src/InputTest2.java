public class InputTest2 {
    public static void main(String[] args) {
        String stringValue1 = "TEST 1";
        String stringValue2 = "TEST 2";
        String stringValue3 = "TEST";
        String stringValue4 = " 1";

        System.out.println("stringValue1: " + stringValue1.hashCode());
        System.out.println("stringValue2: " + stringValue2.hashCode());
        System.out.println("stringValue3: " + stringValue3.hashCode());
        System.out.println("stringValue4: " + stringValue4.hashCode());

        stringValue1 = stringValue1 + stringValue2;
        System.out.println("stringValue1: " + stringValue1.hashCode());

        stringValue3 = stringValue3 + stringValue4;
        System.out.println("stringValue3: " + stringValue3.hashCode());

        StringBuffer sb = new StringBuffer();
        System.out.println("sb: " + sb.hashCode());
        sb.append("TEST StringBuffer");
        System.out.println("sb: " + sb.hashCode());
    }
}
