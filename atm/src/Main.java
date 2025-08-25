import atm.Atm;
import model.Bill;
import model.OperationType;
import operation.request.AddMoneyRequest;
import operation.request.WithdrawMoneyRequest;

public class Main {
    public static void main(String[] args) {
        Atm atm = Atm.getInstance();

        // Supposed to be managed by Inventory Manager
        atm.addBill(Bill.FIFTY, 2);
        atm.addBill(Bill.HUNDRED, 5);
        atm.addBill(Bill.FIVE_HUNDRED, 2);
        atm.addBill(Bill.TWO_THOUSAND, 1);


        atm.authenticate("1234", "1234");
        atm.selectOperation(OperationType.ADD_MONEY);
        AddMoneyRequest amr1 = new AddMoneyRequest(350);
        atm.performOperation(amr1);

        atm.selectOperation(OperationType.WITHDRAW);
        WithdrawMoneyRequest wmr1 = new WithdrawMoneyRequest(1000);
        atm.performOperation(wmr1);

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
