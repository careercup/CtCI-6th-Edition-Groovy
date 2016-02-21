package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNode as N
import Ch04_TreesAndGraphs.utils.BiNodeBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static Ch04_TreesAndGraphs._04_12_PathsWithSum.sumPathCount

@Unroll class _04_12_PathsWithSumTest extends Specification {
    /*@formatter:off*/
    def 'sumPathCount from #tree?'() {
        when:   def root = BiNodeBuilder.from(tree) 
        then:   expectedPathCounts.each { sum, expected -> assert sumPathCount(root, sum) == expected }
        
        where:
        tree                                                       | expectedPathCounts
        [1:[0]]                                                    | [0:1,1:2,3:0]
        [1:[0,2]]                                                  | [1:2,2:1,3:1]
        [2:[1,3],1:-1]                                             | [2:2,3:2]
        [3:[2,4],2:0,4:-5]                                         | [2:3,5:2]
        [5:[3,1],3:[-8,8],1:[2,6],2:0]                             | [0:2] 
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:11] | [1:2,3:1,5:2,7:2,8:2,9:3,10:2,11:2,12:3,13:3] 

        new N(-6,new N(1,new N(4,new N(1,new N(5,new N(0,new N(-1)))))))                                                 | [5:7] 
        new N(0,new N(0),new N(0,new N(0,null,new N(0)),new N(0)))                                                       | [0:15, 4:0] 
        new N(-7,new N(-7,null,new N(1,new N(2))),new N(7,new N(3),new N(20,new N(0,new N(-3,null,new N(2,new N(1))))))) | [0:4] 
    }
    /*@formatter:on*/
}
