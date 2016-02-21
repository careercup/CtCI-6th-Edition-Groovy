package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

/** Find the in-order successor of a node in a binary tree */
class _04_06_Successor {
    /** Complexity: O(node.height) */
    static successor(BiNode<Integer> node) {
        descendLeft(node.right) ?: ascendRight(node).parent
    }
    static descendLeft(BiNode node) {
        while (node?.left) node = node.left
        node
    }
    private static ascendRight(BiNode node) {
        while (node?.isRightChild) node = node.parent
        node
    }
}
