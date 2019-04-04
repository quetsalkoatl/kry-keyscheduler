package ch.fhnw.kry.keyscheduler;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Word {

    /**
     * one word is 4 bytes
     */
    private final Byte[] bytes = new Byte[4];

    private Word() {}

    public Word(Byte b0, Byte b1, Byte b2, Byte b3) {
        this.bytes[0] = b0;
        this.bytes[1] = b1;
        this.bytes[2] = b2;
        this.bytes[3] = b3;
    }

    /**
     * constructor for String to Word
     * @param word  String value of Word in given base
     * @param base  Base of String (ex. BIN or HEX)
     */
    public Word(String word, Base base) {
        if (base == Base.DEZ) {
            throw new IllegalArgumentException("decimal not allowed!");
        }
        word = word.replace(" ", "");
        for (int i = 0; i < 4; i++) {
            int beg = word.length() - base.getSize()*(i+1);
            int end = word.length() - base.getSize()*i;
            String pt = word.substring(beg > 0 ? beg : 0, end > 0 ? end : 0);
            this.bytes[3-i] = new Byte(pt.length() == 0 ? "00" : pt, base);
        }
    }

    /**
     * constructor for HEX String to Word
     * @param hex hexadecimal String value of Word
     */
    public Word(String hex) {
        this(hex, Base.HEX);
    }

    /**
     * rotate bytes in word
     * @param in  word to be rotated
     * @return  rotated word
     */
    public static Word rotWord(Word in) {
        return new Word(in.bytes[1], in.bytes[2], in.bytes[3], in.bytes[0]);
    }

    /**
     * get subbyte of all bytes in word
     * @param in  Word to get subbytes for
     * @return  Word containing subbytes
     */
    public static Word subWord(Word in) {
        return new Word(
                SubBytes.get(in.bytes[0]),
                SubBytes.get(in.bytes[1]),
                SubBytes.get(in.bytes[2]),
                SubBytes.get(in.bytes[3])
        );
    }

    /**
     * perform xor operation between two Words
     * @param w1  first word
     * @param w2  second word
     * @return  "xored" Word
     */
    public static Word xor(Word w1, Word w2) {
        Word ret = new Word();
        for (int i = 0; i < 4; i++) {
            ret.bytes[i] = Byte.xor(w1.bytes[i], w2.bytes[i]);
        }
        return ret;
    }

    public Byte[] getBytes() {
        return bytes;
    }

    /**
     * get HEX representation of Word
     * @return  hexadecimal String
     */
    public String getHex() {
        return Arrays.stream(bytes)
                .map(Byte::getHex)
                .collect(Collectors.joining(" "));
    }

    /**
     * get BIN representation of Word
     * @return  binary String
     */
    public String getBin() {
        return Arrays.stream(bytes)
                .map(Byte::getBin)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Arrays.equals(bytes, word.bytes);
    }

    @Override
    public String toString() {
        return getHex();
    }

}
