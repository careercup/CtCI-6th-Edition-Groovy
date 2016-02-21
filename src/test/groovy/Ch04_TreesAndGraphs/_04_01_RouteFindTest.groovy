package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.DiGraph
import spock.lang.Specification
import spock.lang.Unroll

import static Ch04_TreesAndGraphs.GraphTest.fill
import static _04_01_RouteFind.isConnected

@Unroll class _04_01_RouteFindTest extends Specification {
    /*@formatter:off*/
    def 'isConnected?'() {
        when:   def graph = fill(connections, new DiGraph())
        then:   for (v1 in graph.vertices) {
                    def cluster = clusters[v1]
                    for (int v2 in cluster)
                        assert isConnected(graph,v1, v2)
                    for (int v2 in (clusters.values().flatten() - cluster - v1))
                        assert !isConnected(graph, v1, v2)
                }
        where:
        connections                                          | clusters
        [8:[3,10],3:[1,6],6:[4,7],10:14,14:13]               | [1:1,3:[6,7,4,1],6:[7,4],8:[10,14,13,3,6,7,4,1],10:[14,13],14:13]
        [0:[1,2,5,6],5:[3,4],3:4,6:4,7:8,9:[10,11,12],11:12] | [0:[1,2,5,6,3,4],3:4,5:[3,4],6:4,7:8,9:[10,11,12],11:12]
    }
    /*@formatter:on*/
}
