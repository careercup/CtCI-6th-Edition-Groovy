package Ch05_BitManipulation

/** Convert a double in the range (0,1) to a base 2 string */
class _05_02_BinaryTostring {
    /** Complexity: O(1) */
    static toBinary(double num) {
        assert num > 0 && num < 1

        def result = new StringBuilder('0.')
        while (num != num.intValue() && result.length() <= 32) {
            num *= 2
            result << num.intValue() % 2
        }
        result.toString()
    }
}
