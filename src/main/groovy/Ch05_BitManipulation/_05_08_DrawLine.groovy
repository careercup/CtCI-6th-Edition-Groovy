package Ch05_BitManipulation

/** Determine the number of different bits in two numbers */
class _05_08_DrawLine {
    /** Complexity: O(x2-x1) */
    static drawLine(byte[] screen, int byteWidth, int x1, int x2, int y) {
        assert (x1 / Byte.SIZE < byteWidth) && (x2 / Byte.SIZE < byteWidth) && (y < (screen.size() / byteWidth))

        def (firstIndex, lastIndex) = [getIndex(byteWidth, y, x1), getIndex(byteWidth, y, x2)]
        (x1, x2) = [x1 % Byte.SIZE, x2 % Byte.SIZE]

        def (firstMask, lastMask) = [0xFF >>> x1, Byte.MIN_VALUE >> x2]

        if (firstIndex == lastIndex)
            screen[firstIndex] |= (firstMask & lastMask)
        else {
            screen[firstIndex] |= firstMask
            for (i in (firstIndex + 1)..<lastIndex)
                screen[i] = ~0
            screen[lastIndex] |= lastMask
        }

        screen
    }

    private static int getIndex(int width, int y, int x) { (y * width) + (x / Byte.SIZE) }
}
