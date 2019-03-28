package ch.fhnw.kry.keyscheduler;

import org.junit.Test;

import static org.junit.Assert.*;

public class ByteTest {

    @Test
    public void testInit() {
        Byte b1 = new Byte(0);
        Byte b2 = new Byte("00000001", Base.BIN);
        Byte b3 = new Byte(120);
        Byte b4 = new Byte("fe");
        Byte b5 = new Byte(255);

        assertEquals("00", b1.getHex());
        assertEquals("00000000", b1.getBin());
        assertEquals(0, b1.getDez());

        assertEquals("01", b2.getHex());
        assertEquals("00000001", b2.getBin());
        assertEquals(1, b2.getDez());

        assertEquals("78", b3.getHex());
        assertEquals("01111000", b3.getBin());
        assertEquals(120, b3.getDez());

        assertEquals("fe", b4.getHex());
        assertEquals("11111110", b4.getBin());
        assertEquals(254, b4.getDez());

        assertEquals("ff", b5.getHex());
        assertEquals("11111111", b5.getBin());
        assertEquals(255, b5.getDez());
    }

    @Test
    public void testXor() {
        Byte b1 = new Byte("00001111", Base.BIN);
        Byte b2 = new Byte("11110000", Base.BIN);
        Byte b3 = new Byte("10101010", Base.BIN);
        Byte b4 = new Byte("01010101", Base.BIN);

        Byte ex1 = new Byte("00000000", Base.BIN);
        Byte ex2 = new Byte("11111111", Base.BIN);
        Byte ex3 = new Byte("01011010", Base.BIN);

        assertEquals(ex1, Byte.xor(b1, b1));
        assertEquals(ex2, Byte.xor(b1, b2));
        assertEquals(ex2, Byte.xor(b3, b4));
        assertEquals(ex3, Byte.xor(b1, b4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitException1() {
        new Byte("a93");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitException2() {
        new Byte(-23);
    }

}