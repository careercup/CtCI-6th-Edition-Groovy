package Ch05_BitManipulation

/** Find the length of the longest sequence of 1s, if you're allowed to flip a 0 to 1 */
class _05_03_FlipBitToWin {
    /** Complexity: O(1) */
    static maxSequence(int num) {
        List<Integer> counts = getCounts(num)
        getMaxCount(counts)
    }
    private static getCounts(int num) {
        def counts = [0]
        while (num != 0) {
            def digit = num & 1
            num >>>= 1
            counts += (digit == 1) ? counts.pop() + 1
                                   : 0
        }
        counts
    }
    private static getMaxCount(List<Integer> counts) {
        def (maxCount, prev) = [0, 0]
        for (count in counts) {
            maxCount = [maxCount, prev + count].max()
            prev = count
        }
        [Integer.SIZE, maxCount + 1].min()
    }
}
