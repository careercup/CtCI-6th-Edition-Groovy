package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

import static java.lang.Math.abs
import static java.lang.Math.max

/** Check whether a binary tree is balanced */
class _04_04_CheckBalanced {
    /** Complexity: O(root.size) */
    static isBalanced(BiNode root) {
        abs(height(root.left) - height(root.right)) < 2
    }
    static height(BiNode root) {
        root ? 1 + max(height(root.left), height(root.right))
             : 0
    }
}