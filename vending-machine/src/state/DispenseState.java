package state;

import entity.VendingMachine;
import model.Item;
import model.Money;

public class DispenseState extends State {

    public DispenseState(VendingMachine machine) {
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
        Item item = machine.getItem(machine.getSelectedItemCode());
        int remainingBalance = machine.getBalance() - item.getPrice();
        machine.setBalance(remainingBalance);

        machine.reduceSelectedItem();
        System.out.println("Dispensing item: " + item.getName());

        machine.setState(new RefundState(machine));
        machine.refund();
    }

    @Override
    public void refund() {
        System.out.println("Cannot refund");
    }
}
