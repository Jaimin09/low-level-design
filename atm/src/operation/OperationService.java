package operation;

import model.Account;
import operation.request.OperationRequest;

public interface OperationService<S extends OperationRequest> {
    void operate(Account account, S request);
}
