package model;

import lombok.Getter;

public enum Bill {
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    TWO_THOUSAND(200);

    @Getter
    private int value;
    Bill(int value) {
        this.value = value;
    }
}
