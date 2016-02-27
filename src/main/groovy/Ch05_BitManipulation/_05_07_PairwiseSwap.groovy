package Ch05_BitManipulation

/** Determine the number of different bits in two numbers */
class _05_07_PairwiseSwap {
    /** Complexity: O(1) */
    private static ODD_MASK = 0b01010101_01010101_01010101_01010101
    static swapOddEvenBits(int num) {
        ((num >> 1) & ODD_MASK) | ((num & ODD_MASK) << 1)
    }
}
