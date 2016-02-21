package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.DiGraph

/** Given a DAG, sort the nodes based on their dependencies */
class _04_07_BuildOrder {
    /** Complexity: O(graph.nodes) */
    static buildOrder(DiGraph graph) {
        def results = [] as LinkedHashSet
        for (int v in graph.vertices)
            postOrderCollect(graph, v, results)
        results
    }

    static postOrderCollect(DiGraph graph, int v1, Set results, Set visited = []) {
        if (!visited.add(v1)) throw new IllegalStateException('Cycle detected!')

        for (v2 in graph.neighbors(v1))
            if ((v1 != v2) && !results.contains(v2))
                postOrderCollect(graph, v2, results, visited)
        visited.clear()
        results.add(v1)
    }
}
