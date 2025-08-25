package atm;

import lombok.Getter;
import lombok.Setter;
import model.Account;
import model.Bill;
import model.Card;
import model.OperationType;
import operation.AddMoneyService;
import operation.OperationService;
import operation.WithdrawMoneyService;
import operation.request.OperationRequest;
import state.AuthenticateState;
import state.State;

import java.util.EnumMap;
import java.util.Map;

public class Atm {
    private static Atm instance;
    Inventory inventory;
    @Setter
    private State currentState;
    Map<String, Account> accounts;
    Map<OperationType, OperationService> operationServiceMap;
    @Getter
    @Setter
    private OperationType currentOperation;
    @Setter
    @Getter
    private String currentCardId;

    private Atm() {
        currentState = new AuthenticateState();
        this.inventory = new Inventory();
        this.currentOperation = OperationType.IDLE;
        // Hard coding for now
        accounts = Map.of(
                "1234", new Account("3456", "Jay", new Card("1234", "Jay", "1234"), 500)
        );
        operationServiceMap = Map.of(
                OperationType.WITHDRAW, new WithdrawMoneyService(),
                OperationType.ADD_MONEY, new AddMoneyService()
        );
        currentCardId = null;
    }

    public static synchronized Atm getInstance() {
        if (instance == null) {
            instance = new Atm();
        }
        return instance;
    }

    public Account getAccount(String cardId) {
        return accounts.get(cardId);
    }

    public OperationService getOperationService(OperationType operationType) {
        if (!operationServiceMap.containsKey(operationType)) {
            throw new RuntimeException("Operation type " + operationType + " not found");
        }
        return operationServiceMap.get(operationType);
    }

    public void addBill(Bill bill, int quantity) {
        inventory.addBill(bill, quantity);
    }

    // State methods;
    public void authenticate(String cardNumber, String pin) {
        currentState.authenticateCard(this, cardNumber, pin);
    }

    public void selectOperation(OperationType operationType) {
        currentState.selectOperation(this, operationType);
    }

    public void performOperation(OperationRequest operationRequest) {
        currentState.operate(this, operationRequest);
    }

    public void cancel() {
        currentState.cancel(this);
    }
}
