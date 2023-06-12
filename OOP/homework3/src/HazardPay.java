public class HazardPay extends PayCalculator {
    public HazardPay() {
        super(1.0);
    }

    @Override
    public double computePay(double hours) {
        return super.computePay(hours) * 1.5;
    }
}
