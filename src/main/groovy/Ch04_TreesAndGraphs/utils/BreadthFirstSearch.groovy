package Ch04_TreesAndGraphs.utils

class BreadthFirstSearch implements Search {
    static of(Graph graph, int vertex = 0, Closure<Boolean> visit) { new BreadthFirstSearch().search(graph, vertex, visit) }

    @Override add(Deque<Integer> chain, int vertex) { chain.addLast(vertex) }
}
