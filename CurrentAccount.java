public class CurrentAccount extends Account {
    private final double overdraftLimit;
    private static final double MAINTENANCE_FEE = 10.0;

    public CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (balance - amount < -overdraftLimit) {
            System.out.println("[" + accountNumber + "] Withdrawal of " + amount
                    + " rejected: exceeds overdraft limit of " + overdraftLimit);
        } else {
            balance -= amount;
            System.out.println("[" + accountNumber + "] Withdrew " + amount
                    + ". New balance: " + balance
                    + (balance < 0 ? " (in overdraft)" : ""));
        }
    }

    @Override
    public void endOfMonth() {
        balance -= MAINTENANCE_FEE;
        System.out.println("[" + accountNumber + "] Maintenance fee " + MAINTENANCE_FEE
                + " deducted. New balance: " + balance);
    }
}