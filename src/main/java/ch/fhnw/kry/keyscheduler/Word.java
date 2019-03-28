package ch.fhnw.kry.keyscheduler;

import java.util.Arrays;

public class Word {

    private Byte[] bytes = new Byte[4];

    private Word() {}

    public Word(Byte b0, Byte b1, Byte b2, Byte b3) {
        this.bytes[0] = b0;
        this.bytes[1] = b1;
        this.bytes[2] = b2;
        this.bytes[3] = b3;
    }

    public Word(String word, Base base) {
        if(base == Base.DEZ) {
            throw new IllegalArgumentException("decimal not allowed!");
        }
        word = word.replace(" ", "");
        for(int i = 0, j = 3; i < 4; i++, j--) {
            int beg = word.length() - base.getSize()*(i+1);
            int end = word.length() - base.getSize()*i;
            String pt = word.substring(beg > 0 ? beg : 0, end > 0 ? end : 0);
            this.bytes[j] = new Byte(pt.length() == 0 ? "00" : pt, base);
        }
    }

    public Word(String hex) {
        this(hex, Base.HEX);
    }

    public static Word rotWord(Word in) {
        return new Word(in.bytes[1], in.bytes[2], in.bytes[3], in.bytes[0]);
    }

    public static Word subWord(Word in) {
        return new Word(
                SubBytes.get(in.bytes[0]),
                SubBytes.get(in.bytes[1]),
                SubBytes.get(in.bytes[2]),
                SubBytes.get(in.bytes[3])
        );
    }

    public static Word xor(Word w1, Word w2) {
        Word ret = new Word();
        for(int i = 0; i < 4; i++) {
            ret.bytes[i] = Byte.xor(w1.bytes[i], w2.bytes[i]);
        }
        return ret;
    }

    public String getHex() {
        StringBuilder sb = new StringBuilder(8);
        for (Byte b : bytes) {
            sb.append(b.getHex());
        }
        return sb.toString();
    }

    public String getBin() {
        StringBuilder sb = new StringBuilder(8);
        for (Byte b : bytes) {
            sb.append(b.getBin());
        }
        return sb.toString();
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
