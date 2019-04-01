package ch.fhnw.kry.keyscheduler;

public class AddRoundKey {

    public static Byte[] addRoundKey(int round, Word[] w, Byte[] s, int nr, int nb) {
        if (round < 0 || round > nr) {
            throw new IllegalArgumentException("round must be between 0 and " + nr);
        }
        if (s.length != 4*nb) {
            throw new IllegalArgumentException("s length must be " + 4*nb);
        }
        Byte[] ret = new Byte[4*nb];
        for (int c = 0; c < nr; c++) {
            Word row = new Word(s[c], s[4+c], s[8+c], s[12+c]);
            Byte[] tmp = Word.xor(row, w[round*nb+c]).getBytes();
            for (int i = 0; i < tmp.length; i++) {
                ret[4*i + c] = tmp[i];
            }
        }
        return ret;
    }

    public static Byte[] addRoundKey128(int round, Word[] w, Byte[] s) {
        return addRoundKey(round, w, s, 10, 4);
    }

}
