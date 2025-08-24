package entity;

import lombok.Getter;
import lombok.Setter;
import model.Item;
import model.Money;
import state.SelectItemState;
import state.State;

public class VendingMachine {
    private static VendingMachine instance;
    private State state;
    private Inventory inventory;
    @Getter
    @Setter
    private int balance;
    @Getter
    private String selectedItemCode = null;

    VendingMachine() {
        state = new SelectItemState(this);
    }

    public static VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }

    public void reset() {
        this.state = new SelectItemState(this);
        this.balance = 0;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Item getItem(String itemCode) {
        return inventory.getItem(itemCode);
    }

    public boolean isItemAvailable(String code) {
        return inventory.isItemAvailable(code);
    }

    public void setSelectedItemCode(String selectedItemCode) {
        this.selectedItemCode = selectedItemCode;
    }

    public void reduceSelectedItem() {
        inventory.reduceItem(selectedItemCode);
    }

    // State methods
    public void selectItem(String itemCode) {
        state.selectItem(itemCode);
    }

    public void addMoney(Money money) {
        state.addMoney(money);
    }

    public void dispense() {
        state.dispense();
    }

    public void refund() {
        state.refund();
    }
}
