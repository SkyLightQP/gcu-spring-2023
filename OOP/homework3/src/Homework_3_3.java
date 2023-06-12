public class Homework_3_3 {
    public static void main(String[] args) {
        RegularPay regularPay = new RegularPay(10.0);
        System.out.println("Regular pay (5 hours): " + regularPay.computePay(5));

        HazardPay hazardPay = new HazardPay();
        System.out.println("Hazard pay (5 hours): " + hazardPay.computePay(5));
    }
}
