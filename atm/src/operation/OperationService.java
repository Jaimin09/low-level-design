package operation;

import model.Account;

public interface OperationService {
    void operate(Account account, int... args);
}
