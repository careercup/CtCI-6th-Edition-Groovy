package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNodeBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static Ch04_TreesAndGraphs._04_11_RandomTreeNode.getRandomNode
import static java.lang.Math.abs

@Unroll class _04_11_RandomTreeNodeTest extends Specification {
    /*@formatter:off*/
    def 'getRandomNode from #tree?'() {
        given:  def repetitions = 1000
                def threshold = repetitions * 0.1

        when:   def root = BiNodeBuilder.from(tree)
        and:    def choices = [:].withDefault { 0 }
                (root.size * repetitions).times { choices[getRandomNode(root)]++ } 
                def frequencies = choices.values()
        then:   frequencies.each { assert abs(it - repetitions) <= threshold }
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
}
