import java.util.ArrayList;
import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV-001", 1000, 100));
        accounts.add(new SavingsAccount("SAV-002", 150, 100));
        accounts.add(new CurrentAccount("CUR-001", 200, 500));
        accounts.add(new CurrentAccount("CUR-002", 50, 500));

        System.out.println("=== Withdrawals (amount = 100) ===");
        for (Account acc : accounts) {
            acc.withdraw(100);
        }

        System.out.println("\n=== End of month ===");
        for (Account acc : accounts) {
            acc.endOfMonth();
        }
    }
}