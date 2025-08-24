package operation;

import model.Account;

public class WithdrawMoneyService implements OperationService {
    @Override
    public void operate(Account account, int... args) {
        // In real, this should selected by user interaction
        if (args.length == 0) {
            System.out.println("Please input money amount, no operation performed");
            return;
        }
        int money = args[0];
        System.out.println("Withdrawing " + money);
        account.setBalance(account.getBalance() + money);
        System.out.println("Account balance is now: " + account.getBalance());
    }
}
