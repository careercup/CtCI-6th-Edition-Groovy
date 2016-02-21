package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode
import Ch04_TreesAndGraphs.utils.BiNodeBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static _04_06_Successor.successor

@Unroll class _04_06_SuccessorTest extends Specification {
    /*@formatter:off*/
    def 'successor from #tree?'() {
        given:  def root = BiNodeBuilder.from(tree)
                def nodes = collectNodes(root)

        when:   def vertices = nodes*.value
                def size = vertices.max()
        then:   vertices.size() - 1 == size

        when:   def expectedSuccessors = (1..size) + null
        then:   nodes.collect { successor(it) }*.value == expectedSuccessors

        where:
        tree                                                              | _
        [1:[0]]                                                           | _
        [1:[0,2]]                                                         | _
        [2:[1,3],1:0]                                                     | _
        [3:[2,4],2:1,1:0]                                                 | _
        [4:[2,6],2:[1,3],1:0,6:[5,7]]                                     | _
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:[null,11]] | _
    }
    /*@formatter:on*/

    static collectNodes(BiNode node) {
        Set<BiNode> nodes = [node]
        while (true)
            if (nodes.every { !nodes.add(it?.left) && !nodes.add(it?.right) })
                return nodes.findAll().sort { it.value }.collect()
    }
}
