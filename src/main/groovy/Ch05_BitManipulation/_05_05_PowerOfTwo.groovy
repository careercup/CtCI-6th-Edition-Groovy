package Ch05_BitManipulation

/** Determine whether a number is a power of 2 */
class _05_05_PowerOfTwo {
    /** Complexity: O(1) */
    static isPowerOf2(int num) {
        (num > 0) && ((num & (num - 1)) == 0)
    }
}
