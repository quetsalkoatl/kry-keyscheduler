package ch.fhnw.kry.keyscheduler;

/**
 * wrapper to convert between number bases
 */
public enum Base {

    /**
     * decimal
     */
    DEZ(10, 3),

    /**
     * binary
     */
    BIN(2, 8),

    /**
     * hexadecimal
     */
    HEX(16, 2);

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
