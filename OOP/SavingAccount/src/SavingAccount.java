public class SavingAccount {
    private double balance;
    public static double interestRate;
    public static int numberOfAcounts = 0;

    public SavingAccount() {
        balance = 0;
        numberOfAcounts++;
    }

    public static void setInterestRate(double interestRate) {
        SavingAccount.interestRate = interestRate;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static int getNumberOfAcounts() {
        return numberOfAcounts;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public double withdrew(double amount) {
        if (this.balance - amount < 0) {
            System.out.println("ERROR: Can not withdraw more than balance.");
            System.exit(0);
        }
        this.balance -= amount;
        return this.balance;
    }

    public void addInterest() {
        this.balance += this.balance * interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public static void showBalance(SavingAccount account) {
        System.out.println(account.getBalance());
    }
}
