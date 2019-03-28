package ch.fhnw.kry.keyscheduler;

public class KeySchedule {

    private static final Word[] rcon = {
            new Word("01000000"), new Word("02000000"),
            new Word("04000000"), new Word("08000000"),
            new Word("10000000"), new Word("20000000"),
            new Word("40000000"), new Word("80000000"),
            new Word("1b000000"), new Word("36000000")
    };

    public static Word[] keyExpansion(Byte[] key) {
        if (key.length != 16) {
            throw new IllegalArgumentException("Key size must be 16 Byte");
        }
        Word[] w = new Word[44];
        for (int i = 0; i < 4; i++) {
            w[i] = new Word(key[4*i],key[4*i+1],key[4*i+2],key[4*i+3]);
        }
        for (int i = 4; i < 44; i++) {
            Word tmp = w[i-1];
            if (i % 4 == 0) {
                tmp = Word.xor(Word.subWord(Word.rotWord(tmp)), rcon[i/4 - 1]);
            }
            w[i] = Word.xor(w[i-4], tmp);
        }
        return w;
    }

}
