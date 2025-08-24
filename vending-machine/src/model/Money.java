package model;

public enum Money {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10);

    private int value;

    Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
