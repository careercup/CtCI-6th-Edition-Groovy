package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

/** Given a sorted, unique array, create a balanced BST */
class _04_02_MinimalTree {
    /** Complexity: O(values.size()) */
    static createBst(List<Integer> values, Range range = 0..<values.size()) {
        if (isInvalid(range)) return null

        def middle = middle(range)
        new BiNode(values[middle],
                   createBst(values, range.from..<middle),
                   createBst(values, (middle + 1)..range.to))
    }
    private static isInvalid(Range range) { range.empty || range.reverse }
    private static middle(IntRange range) { range.from + (range.size() >> 1) }
}