package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

import java.util.concurrent.atomic.AtomicInteger as Int

/** Check whether a binary tree is a BST */
class _04_05_CheckBst {
    /** Complexity: O(node.size) */
    static isBst(BiNode<Integer> node, Int previous = new Int(Integer.MIN_VALUE)) {
        if (!node) return true
        else if (!isBst(node.left, previous) || (previous.get() >= node.value)) return false
        previous.set(node.value)
        isBst(node.right, previous)
    }
}