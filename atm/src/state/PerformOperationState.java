package state;

import atm.Atm;
import model.Account;
import model.OperationType;
import operation.OperationService;
import operation.request.OperationRequest;
import operation.request.WithdrawMoneyRequest;

public class PerformOperationState implements State{

    @Override
    public void authenticateCard(Atm atm, String cardNumber, String cardPin) {
        System.out.println("Already authenticated");
    }

    @Override
    public void operate(Atm atm, OperationRequest operationRequest) {
        OperationService operationService = atm.getOperationService(atm.getCurrentOperation());
        Account account = atm.getAccount(atm.getCurrentCardId());

        operationService.operate(account, operationRequest);
        System.out.println("Going back to selection menu...");
        atm.setCurrentState(new SelectOperationState());
    }

    @Override
    public void selectOperation(Atm atm, OperationType operationType) {
        System.out.println("Operation " + atm.getCurrentOperation() + " already selected selected!");
    }

    @Override
    public void cancel(Atm atm) {
        atm.setCurrentState(new AuthenticateState());
        System.out.println("Operation cancelled");
    }
}
