package ch.fhnw.kry.keyscheduler;

public class MixColumns {

    private static int[][] rjindael = {
            {2, 3, 1, 1},
            {1, 2, 3, 1},
            {1, 1, 2, 3},
            {3, 1, 1, 2}
    };

    public static Byte[] mixColumns(Byte[] in) {
        Byte[] out = new Byte[in.length];
        for (int i = 0; i < in.length / 4; i++) {
            Byte[] col = {in[i], in[4 + i], in[8 + i], in[12 + i]};
            Byte[] res = mixColumn(col);
            out[i] = res[0];
            out[4 + i] = res[1];
            out[8 + i] = res[2];
            out[12 + i] = res[3];
        }
        return out;
    }

    /**
     * Implementation like: https://www.samiam.org/mix-column.html
     */
    public static Byte[] mixColumn(Byte[] in) {
        Byte[] out = new Byte[4];
        Byte[] a = new Byte[4];
        Byte[] b = new Byte[4];
        for(int c = 0;c < 4; c++) {
            a[c] = in[c];
            b[c] = new Byte((in[c].getDez() << 1) & 0xff);
            if((in[c].getDez() & 0x80) == 0x80) {
                b[c] = new Byte(b[c].getDez() ^ 0x1b); /* Rijndael's Galois field */
            }
        }
        out[0] = new Byte(b[0].getDez() ^ a[3].getDez() ^ a[2].getDez() ^ b[1].getDez() ^ a[1].getDez());
        out[1] = new Byte(b[1].getDez() ^ a[0].getDez() ^ a[3].getDez() ^ b[2].getDez() ^ a[2].getDez());
        out[2] = new Byte(b[2].getDez() ^ a[1].getDez() ^ a[0].getDez() ^ b[3].getDez() ^ a[3].getDez());
        out[3] = new Byte(b[3].getDez() ^ a[2].getDez() ^ a[1].getDez() ^ b[0].getDez() ^ a[0].getDez());
        return out;
    }

}
