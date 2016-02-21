package Ch04_TreesAndGraphs.utils

trait Search {
    def search(DiGraph graph, int v, Closure<Boolean> visit) {
        def (marked, chain) = [new BitSet(), new ArrayDeque<Integer>()]
        marked.set(v)

        while (true) {
            graph.neighbors(v)
                 .findAll { !marked[it] }
                 .each {
                    add(chain, it)
                    marked.set(it)
                 }

            if (!visit(v)) return v
            else if (chain.empty) return null

            v = chain.removeFirst()
        }
    }

    abstract add(Deque<Integer> chain, int vertex)
}