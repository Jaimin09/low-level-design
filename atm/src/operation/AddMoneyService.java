package operation;

import model.Account;
import operation.request.AddMoneyRequest;

public class AddMoneyService implements OperationService<AddMoneyRequest> {
    @Override
    public void operate(Account account, AddMoneyRequest addMoneyRequest) {
        // In real, this should selected by user interaction

        int money = addMoneyRequest.getAmount();
        System.out.println("Adding Money " + money);
        account.setBalance(account.getBalance() + money);
        System.out.println("Account balance is now: " + account.getBalance());
    }

}
