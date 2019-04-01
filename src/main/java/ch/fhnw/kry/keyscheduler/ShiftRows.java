package ch.fhnw.kry.keyscheduler;

public class ShiftRows {

    public static Byte[] shiftRows(Byte[] in) {
        Byte[] out = new Byte[in.length];
        for (int i = 0; i < in.length / 4; i++) {
            Byte[] row = {in[4*i], in[4*i + 1], in[4*i + 2], in[4*i + 3]};
            Byte[] res = shiftRow(row, i);
            System.arraycopy(res, 0, out, 4*i, 4);
        }
        return out;
    }

    public static Byte[] invShiftRows(Byte[] in) {
        Byte[] out = new Byte[in.length];
        for (int i = 0; i < in.length / 4; i++) {
            Byte[] row = {in[4*i], in[4*i + 1], in[4*i + 2], in[4*i + 3]};
            Byte[] res = shiftRow(row, -i);
            System.arraycopy(res, 0, out, 4*i, 4);
        }
        return out;
    }

    private static Byte[] shiftRow(Byte[] in, int shift) {
        if (shift == 0) {
            return in;
        }
        Byte[] out = new Byte[4];
        for (int i = 0; i < in.length; i++) {
            out[(i-shift) % 4] = in[i];
        }
        return out;
    }

}
