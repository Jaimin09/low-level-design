package state;

import entity.VendingMachine;
import model.Money;

public class RefundState extends State {

    RefundState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void selectItem(String itemId) {

    }

    @Override
    public void addMoney(Money money) {

    }

    @Override
    public void dispense() {

    }

}
