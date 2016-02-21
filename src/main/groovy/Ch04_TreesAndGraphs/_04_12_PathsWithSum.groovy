package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

import static Ch04_TreesAndGraphs.utils.BiNode.VisitorType.postOrder
import static Ch04_TreesAndGraphs.utils.BiNode.VisitorType.preOrder

/** Return the number of paths in a binary tree that sum to a given value */
class _04_12_PathsWithSum {
    /** Complexity: O(root.size), uses O(root.maxHeight) space */
    static sumPathCount(BiNode root, int sum) {
        def (cumulativeSums, currentSum, count) = [[:].withDefault { 0 }, 0, 0]
        root.each(
            (preOrder): { BiNode<Integer> node ->
                cumulativeSums[currentSum]++
                currentSum += node.value
                count += cumulativeSums[currentSum - sum]
            },
            (postOrder): { BiNode<Integer> node ->
                currentSum -= node.value
                cumulativeSums[currentSum]-- // TODO Groovy should remove values that are equal to the default
            }
        )
        count
    }
}
