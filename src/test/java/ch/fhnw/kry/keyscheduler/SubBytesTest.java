package ch.fhnw.kry.keyscheduler;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubBytesTest {

    @Test
    public void testGet() {
        Byte b1 = SubBytes.get(0);
        Byte b2 = SubBytes.get("11111111", Base.BIN);
        Byte b3 = SubBytes.get("ac");
        Byte b4 = SubBytes.get(new Byte("39"));

        assertEquals(b1, new Byte("63"));
        assertEquals(b2, new Byte("16"));
        assertEquals(b3, new Byte("91"));
        assertEquals(b4, new Byte("12"));
    }

}
