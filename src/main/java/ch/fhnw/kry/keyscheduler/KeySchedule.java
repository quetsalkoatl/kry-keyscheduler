package ch.fhnw.kry.keyscheduler;

public class KeySchedule {

    /**
     * round constant array for key expansion
     */
    private static final Word[] rcon = {
            new Word("01000000"), new Word("02000000"),
            new Word("04000000"), new Word("08000000"),
            new Word("10000000"), new Word("20000000"),
            new Word("40000000"), new Word("80000000"),
            new Word("1b000000"), new Word("36000000")
    };

    /**
     * key expansion implementation
     * @param key   the key to expand
     * @param conf  AES configuration (ex. AES_128)
     * @return  expanded key as array of Words
     */
    public static Word[] keyExpansion(Byte[] key, AESConfig conf) {
        if (key.length != conf.getKeySize()*4) {
            throw new IllegalArgumentException("Key size must be "+(conf.getKeySize()*4)+" Bytes");
        }

        // initialize expanded key as Word array
        Word[] w = new Word[conf.getBlockSize() * (conf.getRounds()+1)];

        // the bytes of the expanded key are the same as the key
        for (int i = 0; i < conf.getKeySize(); i++) {
            w[i] = new Word(key[4*i],key[4*i + 1],key[4*i + 2],key[4*i + 3]);
        }

        // expand the key
        for (int i = 4; i < w.length; i++) {
            Word tmp = w[i-1];
            if (i % 4 == 0) {
                tmp = Word.xor(Word.subWord(Word.rotWord(tmp)), rcon[i/conf.getKeySize() - 1]);
            }
            w[i] = Word.xor(w[i-4], tmp);
        }
        return w;
    }

}
