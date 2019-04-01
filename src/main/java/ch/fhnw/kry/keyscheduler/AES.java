package ch.fhnw.kry.keyscheduler;

public class AES {

    public static Byte[] cipher(Byte[] in, Word[] expKey, AESConfig conf) {
        int nb = conf.getBlockSize();
        if (in.length != nb*4) {
            throw new IllegalArgumentException("Block size must be " + (nb*4));
        }
        int nr = conf.getRounds();
        Byte[] tmp = new Byte[in.length];
        System.arraycopy(in, 0, tmp, 0, in.length);
        tmp = AddRoundKey.addRoundKey(0, expKey, tmp, nr, nb);

        for (int r = 1; r < nr; r++) {
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = SubBytes.get(tmp[i]);
            }
            tmp = ShiftRows.shiftRows(tmp);
            tmp = MixColumns.mixColumns(tmp);
            tmp = AddRoundKey.addRoundKey(r, expKey, tmp ,nr, nb);
        }

        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = SubBytes.get(tmp[i]);
        }
        tmp = ShiftRows.shiftRows(tmp);
        tmp = AddRoundKey.addRoundKey(nr, expKey, tmp, nr, nb);

        return tmp;
    }

}
