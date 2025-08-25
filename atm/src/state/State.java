package state;

import atm.Atm;
import model.OperationType;
import operation.request.OperationRequest;

public interface State {
    void authenticateCard(Atm atm, String cardNumber, String cardPin);
    void operate(Atm atm, OperationRequest operationRequest);
    void selectOperation(Atm atm, OperationType operationType);
    void cancel(Atm atm);
}
