package atm;

import model.Bill;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Bill, Integer> stock;

    public Inventory() {
        this.stock = new HashMap<>();
    }

    public void addBill(Bill bill, Integer quantity) {
        stock.put(bill, stock.getOrDefault(bill, 0) + quantity);
    }

    public Integer getBillQuantity(Bill bill) {
        return stock.getOrDefault(bill, 0);
    }

    public void deductBill(Bill bill, int amount) {

    }
}
