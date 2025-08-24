package state;

import atm.Atm;
import model.OperationType;

public class SelectOperationState implements State{
    @Override
    public void authenticateCard(Atm atm, String cardNumber, String cardPin) {
        System.out.println("Already authenticated");
    }

    @Override
    public void operate(Atm atm, int... args) {
        System.out.println("Please select operation first");
    }

    @Override
    public void selectOperation(Atm atm, OperationType operationType) {
        atm.setCurrentOperation(operationType);
        System.out.println("Operation " + operationType + " selected!");
        atm.setCurrentState(new PerformOperationState());
    }

    @Override
    public void cancel(Atm atm) {
        atm.setCurrentState(new AuthenticateState());
        System.out.println("Operation cancelled");
    }
}
