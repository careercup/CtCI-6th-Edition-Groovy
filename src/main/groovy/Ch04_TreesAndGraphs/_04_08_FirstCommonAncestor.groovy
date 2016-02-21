package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

import static java.lang.Math.abs

/** Find the common ancestor of two nodes in a binary tree */
class _04_08_FirstCommonAncestor {
    /** Complexity: O(tree.height) */
    static ancestor(BiNode node1, BiNode node2) {
        def depthDiff = depth(node1) - depth(node2)
        (depthDiff > 0) ? abs(depthDiff).times { node1 = node1.parent }
                        : abs(depthDiff).times { node2 = node2.parent }

        while (node1 != node2)
            (node1, node2) = [node1, node2]*.parent

        node1
    }

    static depth(BiNode n) {
        def result = 0
        while (n = n?.parent) result++
        result
    }
}
