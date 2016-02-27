package Ch05_BitManipulation

/** Copy a part of the content of one integer into the other */
class _05_01_Insertion {
    /** Complexity: O(1) */
    static merge(int source, int target, IntRange range) {
        int mask = ~(~0 >>> -range.size() << range.from)
        (source & mask) | (target << range.from)
    }
}