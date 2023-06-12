public abstract class PayCalculator {
    private double payRate;

    public PayCalculator(double payRate) {
        this.payRate = payRate;
    }

    public double computePay(double hours) {
        return hours * payRate;
    }
}
