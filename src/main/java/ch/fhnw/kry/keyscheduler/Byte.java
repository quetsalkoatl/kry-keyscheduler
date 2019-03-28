package ch.fhnw.kry.keyscheduler;

import java.util.Objects;

import static ch.fhnw.kry.keyscheduler.Base.*;

public class Byte {

    private static final String BIN_ZEROES = "00000000";
    private static final String HEX_ZEROES = "00";

    private String hex;

    public Byte(String nr, Base base) {
        nr = nr.replace(" ", "");
        this.hex = Integer.toString(Integer.parseInt(nr, base.getBase()), HEX.getBase());
    }

    public Byte(String nr) {
        this(nr, HEX);
    }

    public Byte(int dez) {
        this.hex = Integer.toString(dez, HEX.getBase());
    }

    public static Byte xor(Byte b1, Byte b2) {
        return new Byte(b1.getDez() ^ b2.getDez());
    }

    public String getHex() {
        return hex.length() <= 2 ? BIN_ZEROES.substring(hex.length()) + hex : hex;
    }

    public String getBin() {
        String bin = Integer.toString(Integer.parseInt(hex, HEX.getBase()), BIN.getBase());
        return bin.length() <= 8 ? BIN_ZEROES.substring(bin.length()) + bin : bin;
    }

    public int getDez() {
        return Integer.parseInt(hex, HEX.getBase());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byte b = (Byte) o;
        return hex.equalsIgnoreCase(b.hex);
    }

}
