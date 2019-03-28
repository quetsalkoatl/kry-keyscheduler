package ch.fhnw.kry.keyscheduler;

public enum Base {

    DEZ(10, 3), BIN(2, 8), HEX(16, 2);

    private int base;
    private int size;

    Base(int base, int size) {
        this.base = base;
        this.size = size;
    }

    public int getBase() {
        return base;
    }

    public int getSize() {
        return size;
    }
}
