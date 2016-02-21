package Ch04_TreesAndGraphs.utils

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = 'neighbors', includeFields = true)
class DiGraph {
    protected List<BitSet> neighbors = [].withDefault { new BitSet(0) }

    def getVertices() { 0..<(neighbors.size()) }
    def getEdges() { /* TODO cache? */
        def edgeCount = vertices.sum(0) { v ->
            neighbors(v).count { it != v }
        }
        0..<edgeCount
    }
    void connect(int v1, int v2) {
        connectSelf(v1, v2)
        neighbors[v1].set(v2)
    }
    def isConnected(int v1, int v2) { isValid(v1) && neighbors[v1].get(v2) }
    def neighbors(int v) { isValid(v) ? neighbors[v].stream().collect() : [] }
    private isValid(int v) { vertices.contains(v) }
    private connectSelf(int ... vertices) { for (v in vertices) neighbors[v].set(v) }

    def copy() {
        def result = new Graph()
        result.neighbors = neighbors*.clone()
        result
    }

    def reverse() {
        def result = new DiGraph()
        for (v1 in vertices)
            for (v2 in neighbors(v1))
                result.connect(v2, v1)
        result
    }
}
