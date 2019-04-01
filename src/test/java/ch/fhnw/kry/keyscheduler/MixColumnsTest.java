package ch.fhnw.kry.keyscheduler;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testcases from: https://www.samiam.org/mix-column.html
 */
public class MixColumnsTest {

    @Test
    public void testMixColumn1() {
        Byte[] in = {
                new Byte("db"),
                new Byte("13"),
                new Byte("53"),
                new Byte("45")
        };

        Byte[] expected = {
                new Byte("8e"),
                new Byte("4d"),
                new Byte("a1"),
                new Byte("bc")
        };

        Byte[] actual = MixColumns.mixColumn(in);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMixColumn2() {
        Byte[] in = {
                new Byte("f2"),
                new Byte("0a"),
                new Byte("22"),
                new Byte("5c")
        };

        Byte[] expected = {
                new Byte("9f"),
                new Byte("dc"),
                new Byte("58"),
                new Byte("9d")
        };

        Byte[] actual = MixColumns.mixColumn(in);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMixColumn3() {
        Byte[] in = {
                new Byte("01"),
                new Byte("01"),
                new Byte("01"),
                new Byte("01")
        };

        Byte[] expected = {
                new Byte("01"),
                new Byte("01"),
                new Byte("01"),
                new Byte("01")
        };

        Byte[] actual = MixColumns.mixColumn(in);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMixColumn4() {
        Byte[] in = {
                new Byte("c6"),
                new Byte("c6"),
                new Byte("c6"),
                new Byte("c6")
        };

        Byte[] expected = {
                new Byte("c6"),
                new Byte("c6"),
                new Byte("c6"),
                new Byte("c6")
        };

        Byte[] actual = MixColumns.mixColumn(in);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMixColumn5() {
        Byte[] in = {
                new Byte("d4"),
                new Byte("d4"),
                new Byte("d4"),
                new Byte("d5")
        };

        Byte[] expected = {
                new Byte("d5"),
                new Byte("d5"),
                new Byte("d7"),
                new Byte("d6")
        };

        Byte[] actual = MixColumns.mixColumn(in);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMixColumn6() {
        Byte[] in = {
                new Byte("2d"),
                new Byte("26"),
                new Byte("31"),
                new Byte("4c")
        };

        Byte[] expected = {
                new Byte("4d"),
                new Byte("7e"),
                new Byte("bd"),
                new Byte("f8")
        };

        Byte[] actual = MixColumns.mixColumn(in);

        assertArrayEquals(expected, actual);
    }

}