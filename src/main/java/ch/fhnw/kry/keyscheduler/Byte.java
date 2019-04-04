package ch.fhnw.kry.keyscheduler;

import static ch.fhnw.kry.keyscheduler.Base.BIN;
import static ch.fhnw.kry.keyscheduler.Base.HEX;

public class Byte {

    private static final String BIN_ZEROES = "00000000";
    private static final String HEX_ZEROES = "00";

    /**
     * Byte is internally stored as int
     */
    private int dez;

    /**
     * constructor for int to Byte
     * @param dez  integer value of Byte
     */
    public Byte(int dez) {
        if (dez < 0 || dez > 255 ) {
            throw new IllegalArgumentException("Only numbers between 0 and 255 allowed");
        }
        this.dez = dez;
    }

    /**
     * constructor for String to Byte
     * @param nr    String value of Byte in given base
     * @param base  Base of String (ex. BIN or HEX)
     */
    public Byte(String nr, Base base) {
        this(Integer.parseInt(nr.replace(" ", ""), base.getBase()));
    }

    /**
     * constructor for HEX String to Byte
     * @param hex hexadecimal String value of Byte
     */
    public Byte(String hex) {
        this(hex, HEX);
    }

    /**
     * perform xor operation between two Bytes
     * @param b1  first Byte
     * @param b2  second Byte
     * @return  "xored" Byte
     */
    public static Byte xor(Byte b1, Byte b2) {
        return new Byte(b1.getDez() ^ b2.getDez());
    }

    /**
     * get HEX representation of Byte (zero-filled)
     * @return  hexadecimal String
     */
    public String getHex() {
        String hex = Integer.toString(dez, HEX.getBase());
        return hex.length() <= 2 ? HEX_ZEROES.substring(hex.length()) + hex : hex;
    }

    /**
     * get BIN representation of Byte (zero-filled)
     * @return  binary String
     */
    public String getBin() {
        String bin = Integer.toString(dez, BIN.getBase());
        return bin.length() <= 8 ? BIN_ZEROES.substring(bin.length()) + bin : bin;
    }

    /**
     * get DEZ representation of Byte (as int)
     * @return  int value of Byte
     */
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
