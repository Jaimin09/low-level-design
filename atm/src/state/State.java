package state;

import atm.Atm;
import model.OperationType;

public interface State {
    void authenticateCard(Atm atm, String cardNumber, String cardPin);
    void operate(Atm atm, int... args);
    void selectOperation(Atm atm, OperationType operationType);
    void cancel(Atm atm);
}
