public class SavingsAccount extends Account {
    private final double minimumBalance;
    private static final double INTEREST_RATE = 0.02;

    public SavingsAccount(String accountNumber, double balance, double minimumBalance) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("[" + accountNumber + "] Withdrawal of " + amount
                    + " rejected: balance cannot fall below minimum of " + minimumBalance);
        } else {
            balance -= amount;
            System.out.println("[" + accountNumber + "] Withdrew " + amount
                    + ". New balance: " + balance);
        }
    }

    @Override
    public void endOfMonth() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("[" + accountNumber + "] Interest added: " + interest
                + ". New balance: " + balance);
    }
}