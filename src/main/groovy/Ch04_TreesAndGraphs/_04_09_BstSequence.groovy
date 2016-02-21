package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode

/** Given a BST, return all the values it could have been built from */
class _04_09_BstSequence {
    /** Complexity: O(node.size!) */
    static sources(BiNode node, Set<BiNode> nodes = [], int size = node.size, Set results = []) {
        nodes.add(node)

        if (nodes.size() == size) results.add(nodes*.value)
        else for (n in nodes)
            for (child in ([n.left, n.right] - nodes).findAll())
                sources(child, nodes.clone(), size, results)

        results
    }
}
