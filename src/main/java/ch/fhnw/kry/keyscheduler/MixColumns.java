package ch.fhnw.kry.keyscheduler;

public class MixColumns {

    private static final Byte[] atable = new Byte[256];
    private static final Byte[] ltable = new Byte[256];

    static {
        generateTables();
    }

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

    public static Byte[] invMixColumns(Byte[] in) {
        Byte[] out = new Byte[in.length];
        for (int i = 0; i < in.length / 4; i++) {
            Byte[] col = {in[i], in[4 + i], in[8 + i], in[12 + i]};
            Byte[] res = invMixColumn(col);
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
        Byte[] a = new Byte[4];
        Byte[] b = new Byte[4];
        for(int c = 0;c < 4; c++) {
            a[c] = in[c];
            b[c] = new Byte((in[c].getDez() << 1) & 0xff);
            if((in[c].getDez() & 0x80) == 0x80) {
                b[c] = new Byte(b[c].getDez() ^ 0x1b); /* Rijndael's Galois field */
            }
        }
        Byte[] out = new Byte[4];
        out[0] = new Byte(b[0].getDez() ^ a[3].getDez() ^ a[2].getDez() ^ b[1].getDez() ^ a[1].getDez());
        out[1] = new Byte(b[1].getDez() ^ a[0].getDez() ^ a[3].getDez() ^ b[2].getDez() ^ a[2].getDez());
        out[2] = new Byte(b[2].getDez() ^ a[1].getDez() ^ a[0].getDez() ^ b[3].getDez() ^ a[3].getDez());
        out[3] = new Byte(b[3].getDez() ^ a[2].getDez() ^ a[1].getDez() ^ b[0].getDez() ^ a[0].getDez());
        return out;
    }

    public static Byte[] invMixColumn(Byte[] in) {
        Byte[] a = new Byte[4];
        for(int c = 0; c < 4; c++) {
            a[c] = in[c];
        }
        Byte[] out = new Byte[4];
        out[0] = new Byte(gmul(a[0],14) ^ gmul(a[3],9) ^ gmul(a[2],13) ^ gmul(a[1],11));
        out[1] = new Byte(gmul(a[1],14) ^ gmul(a[0],9) ^ gmul(a[3],13) ^ gmul(a[2],11));
        out[2] = new Byte(gmul(a[2],14) ^ gmul(a[1],9) ^ gmul(a[0],13) ^ gmul(a[3],11));
        out[3] = new Byte(gmul(a[3],14) ^ gmul(a[2],9) ^ gmul(a[1],13) ^ gmul(a[0],11));
        return out;
    }

    public static int gmul(Byte a, Byte b) {
        return gmul(a.getDez(), b.getDez());
    }

    public static int gmul(Byte a, int b) {
        return gmul(a.getDez(), b);
    }

    public static int gmul(int a, Byte b) {
        return gmul(a, b.getDez());
    }

    public static int gmul(int a, int b) {
        int s;
        int q;
        int z = 0;
        s = ltable[a].getDez() + ltable[b].getDez();
        s %= 255;
        s = atable[s].getDez();
        q = s;
        if(a == 0) {
            s = z;
        } else {
            s = q;
        }
        if(b == 0) {
            s = z;
        }
        return s;
    }

    private static void generateTables() {
        Byte a = new Byte(1);
        Byte d;
        for(int c=0; c < 255; c++) {
            atable[c] = a;
            /* Multiply by three */
            d = new Byte(a.getDez() & 0x80);
            a = new Byte(a.getDez() << 1);
            if(d.getDez() == 0x80) {
                a = new Byte(a.getDez() ^ 0x1b);
            }
            a = new Byte(a.getDez() ^ atable[c].getDez());
            /* Set the log table value */
            ltable[atable[c].getDez()] = new Byte(c);
        }
        atable[255] = atable[0];
        ltable[0] = new Byte(0);
    }

}
