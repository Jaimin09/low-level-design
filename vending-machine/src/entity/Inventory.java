package entity;

import model.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> items;
    private Map<String, Integer> quantity;

    public Inventory() {
        items = new HashMap<>();
        quantity = new HashMap<>();
    }

    public boolean isItemAvailable(String code) {
        return quantity.get(code) != null
                && items.get(code) != null
                && quantity.get(code) > 0;
    }

    public Item getItem(String code) {
        return items.get(code);
    }

    public void reduceItem(String code) {
        quantity.compute(code, (k, v) -> v == 1 ? null : v - 1);
    }

    public void addItem(Item item) {
        String code = item.getCode();
        items.put(code, item);
        quantity.put(code, quantity.getOrDefault(code, 0) + 1);
    }
}
