package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.DiGraph

/** Find out whether there's a route between two nodes in a digraph */
class _04_01_RouteFind {
    /** Complexity: O(graph.edges) */
    static isConnected(DiGraph graph, int v1, int v2) {
        def (Set marked, queue) = [[v1], [v1] as ArrayDeque]
        while (!queue.empty) {
            def node = queue.removeFirst()
            if (node == v2) return true
            graph.neighbors(node).each { marked.add(it) && queue.addLast(it) }
        }
        false
    }
}