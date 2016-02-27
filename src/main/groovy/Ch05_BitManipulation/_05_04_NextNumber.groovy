package Ch05_BitManipulation

/** Given a positive int, find the closest neighbors with the same number of 1s */
class _05_04_NextNumber {
    /** Complexity: O(1) */
    static getPrevious(int num) {
        def ones = trailingOnes(num)
        def zeros = trailingZeros(num >> ones)

        if (ones + zeros >= Integer.SIZE) num
        else num - pow2(ones) - pow2(zeros - 1) + 1
    }

    /** Complexity: O(1) */
    static getNext(int num) {
        def zeros = trailingZeros(num)
        def ones = trailingOnes(num >> zeros)

        if (ones + zeros >= Integer.SIZE) num
        else num + pow2(zeros) + pow2(ones - 1) - 1
    }

    static trailingOnes(int n) { trailingZeros(~n) }
    static trailingZeros(int n) { Integer.numberOfTrailingZeros(n) }
    static pow2(int n) { 1 << n }
}
