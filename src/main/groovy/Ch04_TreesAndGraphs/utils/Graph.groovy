package Ch04_TreesAndGraphs.utils

class Graph extends DiGraph {
    @Override def getEdges() { 0..<(super.edges.size() / 2) }
    @Override void connect(int v1, int v2) {
        super.connect(v1, v2)
        super.connect(v2, v1)
    }
}
