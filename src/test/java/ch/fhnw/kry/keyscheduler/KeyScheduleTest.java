package ch.fhnw.kry.keyscheduler;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Testcases from: https://www.samiam.org/key-schedule.html
 */
public class KeyScheduleTest {

    @Test
    public void testKeyExpansion1() {

        Byte[] key = {
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00")
        };

        Word[] expected = {
                new Word("00 00 00 00"), new Word("00 00 00 00"), new Word("00 00 00 00"), new Word("00 00 00 00"),
                new Word("62 63 63 63"), new Word("62 63 63 63"), new Word("62 63 63 63"), new Word("62 63 63 63"),
                new Word("9b 98 98 c9"), new Word("f9 fb fb aa"), new Word("9b 98 98 c9"), new Word("f9 fb fb aa"),
                new Word("90 97 34 50"), new Word("69 6c cf fa"), new Word("f2 f4 57 33"), new Word("0b 0f ac 99"),
                new Word("ee 06 da 7b"), new Word("87 6a 15 81"), new Word("75 9e 42 b2"), new Word("7e 91 ee 2b"),
                new Word("7f 2e 2b 88"), new Word("f8 44 3e 09"), new Word("8d da 7c bb"), new Word("f3 4b 92 90"),
                new Word("ec 61 4b 85"), new Word("14 25 75 8c"), new Word("99 ff 09 37"), new Word("6a b4 9b a7"),
                new Word("21 75 17 87"), new Word("35 50 62 0b"), new Word("ac af 6b 3c"), new Word("c6 1b f0 9b"),
                new Word("0e f9 03 33"), new Word("3b a9 61 38"), new Word("97 06 0a 04"), new Word("51 1d fa 9f"),
                new Word("b1 d4 d8 e2"), new Word("8a 7d b9 da"), new Word("1d 7b b3 de"), new Word("4c 66 49 41"),
                new Word("b4 ef 5b cb"), new Word("3e 92 e2 11"), new Word("23 e9 51 cf"), new Word("6f 8f 18 8e")
        };

        Word[] result = KeySchedule.keyExpansion(key);

        assertArrayEquals(expected, result);

    }

    @Test
    public void testKeyExpansion2() {

        Byte[] key = {
                new Byte("ff"), new Byte("ff"), new Byte("ff"), new Byte("ff"),
                new Byte("ff"), new Byte("ff"), new Byte("ff"), new Byte("ff"),
                new Byte("ff"), new Byte("ff"), new Byte("ff"), new Byte("ff"),
                new Byte("ff"), new Byte("ff"), new Byte("ff"), new Byte("ff")
        };

        Word[] expected = {
                new Word("ff ff ff ff"), new Word("ff ff ff ff"), new Word("ff ff ff ff"), new Word("ff ff ff ff"),
                new Word("e8 e9 e9 e9"), new Word("17 16 16 16"), new Word("e8 e9 e9 e9"), new Word("17 16 16 16"),
                new Word("ad ae ae 19"), new Word("ba b8 b8 0f"), new Word("52 51 51 e6"), new Word("45 47 47 f0"),
                new Word("09 0e 22 77"), new Word("b3 b6 9a 78"), new Word("e1 e7 cb 9e"), new Word("a4 a0 8c 6e"),
                new Word("e1 6a bd 3e"), new Word("52 dc 27 46"), new Word("b3 3b ec d8"), new Word("17 9b 60 b6"),
                new Word("e5 ba f3 ce"), new Word("b7 66 d4 88"), new Word("04 5d 38 50"), new Word("13 c6 58 e6"),
                new Word("71 d0 7d b3"), new Word("c6 b6 a9 3b"), new Word("c2 eb 91 6b"), new Word("d1 2d c9 8d"),
                new Word("e9 0d 20 8d"), new Word("2f bb 89 b6"), new Word("ed 50 18 dd"), new Word("3c 7d d1 50"),
                new Word("96 33 73 66"), new Word("b9 88 fa d0"), new Word("54 d8 e2 0d"), new Word("68 a5 33 5d"),
                new Word("8b f0 3f 23"), new Word("32 78 c5 f3"), new Word("66 a0 27 fe"), new Word("0e 05 14 a3"),
                new Word("d6 0a 35 88"), new Word("e4 72 f0 7b"), new Word("82 d2 d7 85"), new Word("8c d7 c3 26")
        };

        Word[] result = KeySchedule.keyExpansion(key);

        assertArrayEquals(expected, result);

    }

    @Test
    public void testKeyExpansion3() {

        Byte[] key = {
                new Byte("00"), new Byte("01"), new Byte("02"), new Byte("03"),
                new Byte("04"), new Byte("05"), new Byte("06"), new Byte("07"),
                new Byte("08"), new Byte("09"), new Byte("0a"), new Byte("0b"),
                new Byte("0c"), new Byte("0d"), new Byte("0e"), new Byte("0f")
        };

        Word[] expected = {
                new Word("00 01 02 03"), new Word("04 05 06 07"), new Word("08 09 0a 0b"), new Word("0c 0d 0e 0f"),
                new Word("d6 aa 74 fd"), new Word("d2 af 72 fa"), new Word("da a6 78 f1"), new Word("d6 ab 76 fe"),
                new Word("b6 92 cf 0b"), new Word("64 3d bd f1"), new Word("be 9b c5 00"), new Word("68 30 b3 fe"),
                new Word("b6 ff 74 4e"), new Word("d2 c2 c9 bf"), new Word("6c 59 0c bf"), new Word("04 69 bf 41"),
                new Word("47 f7 f7 bc"), new Word("95 35 3e 03"), new Word("f9 6c 32 bc"), new Word("fd 05 8d fd"),
                new Word("3c aa a3 e8"), new Word("a9 9f 9d eb"), new Word("50 f3 af 57"), new Word("ad f6 22 aa"),
                new Word("5e 39 0f 7d"), new Word("f7 a6 92 96"), new Word("a7 55 3d c1"), new Word("0a a3 1f 6b"),
                new Word("14 f9 70 1a"), new Word("e3 5f e2 8c"), new Word("44 0a df 4d"), new Word("4e a9 c0 26"),
                new Word("47 43 87 35"), new Word("a4 1c 65 b9"), new Word("e0 16 ba f4"), new Word("ae bf 7a d2"),
                new Word("54 99 32 d1"), new Word("f0 85 57 68"), new Word("10 93 ed 9c"), new Word("be 2c 97 4e"),
                new Word("13 11 1d 7f"), new Word("e3 94 4a 17"), new Word("f3 07 a7 8b"), new Word("4d 2b 30 c5")
        };

        Word[] result = KeySchedule.keyExpansion(key);

        assertArrayEquals(expected, result);

    }

    @Test
    public void testKeyExpansion4() {

        Byte[] key = {
                new Byte("69"), new Byte("20"), new Byte("e2"), new Byte("99"),
                new Byte("a5"), new Byte("20"), new Byte("2a"), new Byte("6d"),
                new Byte("65"), new Byte("6e"), new Byte("63"), new Byte("68"),
                new Byte("69"), new Byte("74"), new Byte("6f"), new Byte("2a")
        };

        Word[] expected = {
                new Word("69 20 e2 99"), new Word("a5 20 2a 6d"), new Word("65 6e 63 68"), new Word("69 74 6f 2a"),
                new Word("fa 88 07 60"), new Word("5f a8 2d 0d"), new Word("3a c6 4e 65"), new Word("53 b2 21 4f"),
                new Word("cf 75 83 8d"), new Word("90 dd ae 80"), new Word("aa 1b e0 e5"), new Word("f9 a9 c1 aa"),
                new Word("18 0d 2f 14"), new Word("88 d0 81 94"), new Word("22 cb 61 71"), new Word("db 62 a0 db"),
                new Word("ba ed 96 ad"), new Word("32 3d 17 39"), new Word("10 f6 76 48"), new Word("cb 94 d6 93"),
                new Word("88 1b 4a b2"), new Word("ba 26 5d 8b"), new Word("aa d0 2b c3"), new Word("61 44 fd 50"),
                new Word("b3 4f 19 5d"), new Word("09 69 44 d6"), new Word("a3 b9 6f 15"), new Word("c2 fd 92 45"),
                new Word("a7 00 77 78"), new Word("ae 69 33 ae"), new Word("0d d0 5c bb"), new Word("cf 2d ce fe"),
                new Word("ff 8b cc f2"), new Word("51 e2 ff 5c"), new Word("5c 32 a3 e7"), new Word("93 1f 6d 19"),
                new Word("24 b7 18 2e"), new Word("75 55 e7 72"), new Word("29 67 44 95"), new Word("ba 78 29 8c"),
                new Word("ae 12 7c da"), new Word("db 47 9b a8"), new Word("f2 20 df 3d"), new Word("48 58 f6 b1")
        };

        Word[] result = KeySchedule.keyExpansion(key);

        assertArrayEquals(expected, result);

    }

    @Test
    public void testKeyExpansionFail() {

        Byte[] key = {
                new Byte("69"), new Byte("20"), new Byte("e2"), new Byte("99"),
                new Byte("a5"), new Byte("20"), new Byte("2a"), new Byte("6d"),
                new Byte("65"), new Byte("6e"), new Byte("63"), new Byte("68"),
                new Byte("69"), new Byte("74"), new Byte("6f"), new Byte("2a")
        };

        // one bit changed                                         |
        // row and col marked with arrow                           V
        Word[] expected = {
                new Word("69 20 e2 99"), new Word("a5 20 2a 6d"), new Word("65 6e 63 68"), new Word("69 74 6f 2a"),
                new Word("fa 88 07 60"), new Word("5f a8 2d 0d"), new Word("3a c6 4e 65"), new Word("53 b2 21 4f"),
                new Word("cf 75 83 8d"), new Word("90 dd ae 80"), new Word("aa 1b e0 e5"), new Word("f9 a9 c1 aa"),
                new Word("18 0d 2f 14"), new Word("88 d0 81 94"), new Word("22 cb 61 71"), new Word("db 62 a0 db"),
                new Word("ba ed 96 ad"), new Word("32 3d 17 39"), new Word("10 f6 76 48"), new Word("cb 94 d6 93"),
                new Word("88 1b 4a b2"), new Word("ba 26 5d 8b"), new Word("aa d0 2b c3"), new Word("61 44 fd 50"),
                new Word("b3 4f 19 5d"), new Word("09 69 44 d6"), new Word("a3 b9 6f 15"), new Word("c2 fd 92 45"),
                new Word("a7 00 77 78"), new Word("ae 69 33 ae"), new Word("0d d0 5c bb"), new Word("cf 2d ce fe"),
                new Word("ff 8b cc f2"), new Word("51 e2 ff 5c"), new Word("5c 32 a3 e7"), new Word("93 1f 6d 19"),
                new Word("24 b7 18 2e"), new Word("75 55 e7 72"), new Word("29 67 44 95"), new Word("ba 78 29 8c"),
                new Word("ae 12 7c da"), new Word("db 47 99 a8"), new Word("f2 20 df 3d"), new Word("48 58 f6 b1")  // <-- changed bit
        };

        Word[] result = KeySchedule.keyExpansion(key);

        assertFalse(Arrays.equals(expected, result));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testKeyExpansionException1() {

        Byte[] key = {
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00")
        };

        KeySchedule.keyExpansion(key);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testKeyExpansionException2() {

        Byte[] key = {
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00"), new Byte("00"), new Byte("00"), new Byte("00"),
                new Byte("00")
        };

        KeySchedule.keyExpansion(key);

    }

}