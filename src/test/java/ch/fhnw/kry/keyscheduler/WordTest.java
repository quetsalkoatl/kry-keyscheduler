package ch.fhnw.kry.keyscheduler;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    @Test
    public void testInit() {
        Word w1 = new Word("12 34 56 78");
        Word w2 = new Word("00010010 00110100 01010110 01111000", Base.BIN);

        assertEquals(w1, w2);
        assertEquals("12 34 56 78", w2.getHex());
        assertEquals("00010010 00110100 01010110 01111000", w1.getBin());
    }

    @Test
    public void testRotWord() {
        Byte b1 = new Byte("13");
        Byte b2 = new Byte("57");
        Byte b3 = new Byte("9b");
        Byte b4 = new Byte("df");

        Word w = new Word(b1, b2, b3, b4);
        Word ex = new Word(b2, b3, b4, b1);

        assertEquals(ex, Word.rotWord(w));
    }

    @Test
    public void testSubWord() {
        Word w = new Word("13 57 9b df");
        Word ex = new Word("7d 5b 14 9e");

        assertEquals(ex, Word.subWord(w));
    }

    @Test
    public void testXor() {
        Byte b1 = new Byte("10011100", Base.BIN);
        Byte b2 = new Byte("10100101", Base.BIN);
        Byte b3 = new Byte("00011000", Base.BIN);
        Byte b4 = new Byte("01110110", Base.BIN);

        Word w1 = new Word(b1, b2, b3, b4);
        Word w2 = new Word(b3, b1, b2, b4);

        Word ex = new Word("10000100 00111001 10111101 00000000", Base.BIN);

        assertEquals(ex, Word.xor(w1, w2));
    }
}
