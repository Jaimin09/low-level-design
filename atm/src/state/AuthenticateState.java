package state;


import atm.Atm;
import model.OperationType;

public class AuthenticateState implements State {

    @Override
    public void authenticateCard(Atm atm, String cardNumber, String cardPin) {
        // Some authentication logic here
        atm.setCurrentCardId(cardNumber);
        System.out.println("Card authenticated: " + cardNumber + " pin: xxxx");
        atm.setCurrentState(new SelectOperationState());
    }

    @Override
    public void operate(Atm atm, int... args) {
        System.out.println("Please authenticate first");
    }

    @Override
    public void selectOperation(Atm atm, OperationType operationType) {
        System.out.println("Please authenticate first");
    }

    @Override
    public void cancel(Atm atm) {
        System.out.println("No cancellation required");
    }
}
