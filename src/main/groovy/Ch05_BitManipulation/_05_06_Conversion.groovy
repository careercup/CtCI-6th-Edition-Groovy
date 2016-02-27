package Ch05_BitManipulation

/** Determine the number of different bits in two numbers */
class _05_06_Conversion {
    /** Complexity: O(1) */
    static differences(int source, int target) {
        Integer.bitCount(source ^ target)
    }
}
