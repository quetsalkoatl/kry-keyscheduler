package ch.fhnw.kry.keyscheduler;

public enum AESConfig {
    AES_128(4, 4, 10),
    AES_192(6, 4, 12),
    AES_256(8, 4, 14);

    private int keySize;
    private int blockSize;
    private int rounds;

    AESConfig(int keySize, int blockSize, int rounds) {
        this.keySize = keySize;
        this.blockSize = blockSize;
        this.rounds = rounds;
    }

    public int getKeySize() {
        return keySize;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getRounds() {
        return rounds;
    }
}
