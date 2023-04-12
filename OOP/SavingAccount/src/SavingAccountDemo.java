public class SavingAccountDemo {
    public static void main(String[] args) {
        SavingAccount.setInterestRate(1.5);

        SavingAccount acc = new SavingAccount();
        SavingAccount you = new SavingAccount();

        acc.deposit(100);
        System.out.println("acc) deposit $100.");

        you.deposit(75);
        System.out.println("you) deposit $75.");
        you.deposit(55);
        System.out.println("you) deposit $55.");
        you.withdrew(15.75);
        System.out.println("you) withdrew $15.75");
        you.addInterest();
        System.out.println("You received interest.");

        System.out.println("acc) balance: $" + acc.getBalance());
        System.out.println("you) balance: $" + you.getBalance());

        System.out.println("We opened " + SavingAccount.getNumberOfAcounts() + " savings accounts today.");
    }
}
