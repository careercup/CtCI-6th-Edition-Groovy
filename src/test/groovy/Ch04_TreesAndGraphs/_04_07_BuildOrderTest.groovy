package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.DiGraph
import spock.lang.Specification
import spock.lang.Unroll

import static Ch04_TreesAndGraphs.GraphTest.fill
import static _04_07_BuildOrder.buildOrder

@Unroll class _04_07_BuildOrderTest extends Specification {
    /*@formatter:off*/
    def 'buildOrder from #connections?'() {
        when:   def graph = fill(connections, new DiGraph())
        then:   buildOrder(graph).toList() == result

        where:
        connections                       || result
        [0:[]]                            || [0]
        [1:0]                             || [0,1]
        [2:1,1:0]                         || [0,1,2]
        [3:[2,1],2:[0,1],1:0]             || [0,1,2,3]
        [4:[3,2,1,0],3:1,2:1,1:0]         || [0,1,2,3,4]

        [3:[0,1],2:3,1:5,0:5]             || [5,0,1,3,2,4]
        [4:0,3:[0,1],2:[3,5],1:[0,5],0:5] || [5,0,1,3,2,4]
        [5:[2,1],2:0,1:[2,4],0:4,3:6]     || [4,0,2,1,6,3,5]
    }

    def 'buildOrder breaks for cycles?'() {
        when:   def graph = fill(connections, new DiGraph())
        and:    buildOrder(graph)
        then:   thrown IllegalStateException

        where:
        connections       | _
        [2:1,1:2]         | _
        [2:1,1:0,0:2]     | _
        [2:1,1:0,0:1]     | _
        [3:2,2:1,1:0,0:2] | _
        [3:2,2:1,1:0,0:3] | _
        [3:1,2:1,1:0,0:3] | _
    }
    /*@formatter:on*/
}
