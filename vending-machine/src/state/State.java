package state;

import entity.VendingMachine;
import model.Money;

public abstract class State {
    VendingMachine machine;

    public State(VendingMachine vendingMachine) {
        this.machine = vendingMachine;
    }

    public abstract void selectItem(String itemId);
    public abstract void addMoney(Money money);
    public abstract void dispense();
    public  void refund() {
        if (machine.getBalance() > 0) {
            System.out.println("Refunding amount: " + machine.getBalance());
            machine.setBalance(0);
        } else {
            System.out.println("No refund needed");
        }
        machine.reset();
    }
}
