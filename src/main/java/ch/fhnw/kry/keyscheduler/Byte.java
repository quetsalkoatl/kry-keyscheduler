package ch.fhnw.kry.keyscheduler;

import static ch.fhnw.kry.keyscheduler.Base.*;

public class Byte {

    private static final String BIN_ZEROES = "00000000";
    private static final String HEX_ZEROES = "00";

    private int dez;

    public Byte(int dez) {
        if (dez < 0 || dez > 255 ) {
            throw new IllegalArgumentException("Only numbers between 0 and 255 allowed");
        }
        this.dez = dez;
    }

    public Byte(String nr, Base base) {
        this(Integer.parseInt(nr, base.getBase()));
    }

    public Byte(String hex) {
        this(hex, HEX);
    }

    public static Byte xor(Byte b1, Byte b2) {
        return new Byte(b1.getDez() ^ b2.getDez());
    }

    public String getHex() {
        String hex = Integer.toString(dez, HEX.getBase());
        return hex.length() <= 2 ? HEX_ZEROES.substring(hex.length()) + hex : hex;
    }

    public String getBin() {
        String bin = Integer.toString(dez, BIN.getBase());
        return bin.length() <= 8 ? BIN_ZEROES.substring(bin.length()) + bin : bin;
    }

    public int getDez() {
        return dez;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byte b = (Byte) o;
        return getDez() == b.getDez();
    }

    @Override
    public String toString() {
        return getHex();
    }

}
