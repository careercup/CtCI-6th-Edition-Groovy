package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

/** Return a random node from a binary tree, with equal probability */
class _04_11_RandomTreeNode {
    /** Complexity: O(root.height) */
    static getRandomNode(BiNode root, Random rand = new Random()) {
        def (randomIndex, rootIndex) = [rand.nextInt(root.size), root.getSize(root.left)]
        switch (randomIndex <=> rootIndex) {
            case -1: return getRandomNode(root.left)
            case 0: return root
            case +1: return getRandomNode(root.right)
        }
    }
}
