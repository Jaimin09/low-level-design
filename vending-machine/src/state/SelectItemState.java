package state;

import entity.VendingMachine;
import model.Item;
import model.Money;

public class SelectItemState extends State{

    public SelectItemState(VendingMachine machine) {
        super(machine);
    }


    @Override
    public void selectItem(String itemId) {
        if (machine.isItemAvailable(itemId)) {
            machine.setSelectedItemCode(itemId);
            machine.setState(new AddMoneyState(machine));
        } else {
            System.out.println("Selected item is not available, please select another");
        }
    }

    @Override
    public void addMoney(Money money) {

    }

    @Override
    public void dispense() {

    }

    @Override
    public void refund() {
        machine.setState(new RefundState(machine));
        machine.refund();
        machine.reset();
    }
}
