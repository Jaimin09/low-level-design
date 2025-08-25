package operation;

import model.Account;
import operation.request.WithdrawMoneyRequest;

public class WithdrawMoneyService implements OperationService<WithdrawMoneyRequest> {
    @Override
    public void operate(Account account, WithdrawMoneyRequest withdrawMoneyRequest) {
        // In real, this should selected by user interaction

        int money = withdrawMoneyRequest.getAmount();
        System.out.println("Withdrawing " + money);
        account.setBalance(account.getBalance() + money);
        System.out.println("Account balance is now: " + account.getBalance());
    }

}
