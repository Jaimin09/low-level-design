package state;

import entity.VendingMachine;
import model.Item;
import model.Money;

public class AddMoneyState extends State {

    public AddMoneyState(VendingMachine machine) {
        super(machine);
    }

    @Override
    public void selectItem(String itemId) {

    }

    @Override
    public void addMoney(Money money) {
        Item item = machine.getItem(machine.getSelectedItemCode());
        machine.addBalance(money.getValue());
        if (machine.getBalance() >= item.getPrice()) {
            machine.setState(new DispenseState(machine));
        }
    }

    @Override
    public void dispense() {

    }

    @Override
    public void refund() {

    }
}
