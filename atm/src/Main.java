import atm.Atm;
import atm.Inventory;
import model.Bill;
import model.OperationType;

public class Main {
    public static void main(String[] args) {
        // Supposed to be managed by Inventory Manager
        Inventory inventory = Inventory.getInstance();
        inventory.addBill(Bill.FIFTY, 2);
        inventory.addBill(Bill.HUNDRED, 5);
        inventory.addBill(Bill.FIVE_HUNDRED, 2);
        inventory.addBill(Bill.TWO_THOUSAND, 1);

        Atm atm = Atm.getInstance();

        atm.authenticate("1234", "1234");
        atm.selectOperation(OperationType.ADD_MONEY);
        atm.performOperation(350);

        atm.selectOperation(OperationType.WITHDRAW);
        atm.performOperation(1000);

        atm.selectOperation(OperationType.WITHDRAW);
        atm.cancel();

        atm.selectOperation(OperationType.WITHDRAW);

    }
}
/*
-------
ATM : Singleton
- Inventory
- State
- Map<cardId, Account>
- Map<OperationType, OperationService>
--------
Inventory
- Map<Bill, int> stock
- addMoney()
- deductMoney()
- getStock()
--------
Authenticate -> SelectOperation -> Finish
State
- authenticate()
- operate(TYPE)
- finish()
---------
WithdrawMoneyService, CheckBalanceService, AddMoneyService
OperationService
- operate()
----------
WithdrawMoneyService
- BillChain
- canHandle()
- handle()
- operate()

*/
