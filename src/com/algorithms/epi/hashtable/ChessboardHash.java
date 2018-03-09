package com.algorithms.epi.hashtable;

public class ChessboardHash {
    public static void main(String[] args) {
        new ChessboardHash().execute();
    }

    /**
     * Every chess board has 64 slots. There are 6 classes of chess pieces
     * So total unique types of pieces = 6 * 2 (for black and white) + 1 for blank space
     * We can come up with a unique hashcode with 832 combinations. When a piece gets moved
     * we need to XOR with the code for empty space at the origin to add it, xor with the value of
     * the piece moved from the original position, xor the value of the piece moved at the destination position. Also
     * xor the blank from the destination to remove the blank.
     */
    private void execute() {
        int value = 0x000F;
        int value2 = 0x2222;
        System.out.println(Integer.toHexString(value ^ value2));
    }
}
