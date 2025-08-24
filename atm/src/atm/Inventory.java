package atm;

import model.Bill;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Inventory instance;
    Map<Bill, Integer> stock;

    private Inventory() {
        this.stock = new HashMap<>();
    }

    public static synchronized Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public void addBill(Bill bill, Integer quantity) {
        stock.put(bill, stock.getOrDefault(bill, 0) + quantity);
    }

    public Integer getBillQuantity(Bill bill) {
        return stock.getOrDefault(bill, 0);
    }
}
