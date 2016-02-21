package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNodeBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static _04_03_DepthLists.createDepthLists

@Unroll class _04_03_DepthListsTest extends Specification {
    /*@formatter:off*/
    def 'createDepthLists from #tree?'() {
        when:   def bst = BiNodeBuilder.from(tree)
        then:   createDepthLists(bst) == result

        where:
        tree                                                                        || result
        [0:[]]                                                                      || [[0]]
        [1:0]                                                                       || [[1],[0]]
        [1:[0,2]]                                                                   || [[1],[0,2]]
        [2:[1,3],1:0]                                                               || [[2],[1,3],[0]]
        [2:[1,4],1:0,4:3]                                                           || [[2],[1,4],[0,3]]
        [3:[1,5],1:[0,2],5:4]                                                       || [[3],[1,5],[0,2,4]]
        [3:[1,5],1:[0,2],5:[4,6]]                                                   || [[3],[1,5],[0,2,4,6]]
        [4:[2,6],2:[1,3],1:0,6:[5,7]]                                               || [[4],[2,6],[1,3,5,7],[0]]

        [7:[4,13],4:[3,6],3:1,13:[10,14],10:8]                                      || [[7],[4,13],[3,6,10,14],[1,8]]
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:[null,11]]           || [[12],[1,13],[0,6],[3,9],[2,5,8,10],[4,7,11]]
        [55:[8,377],8:[2,21],377:[144,987],2:[1,5],21:[13,34],144:[89,233],987:610] || [[55],[8,377],[2,21,144,987],[1,5,13,34,89,233,610]]
    }
    /*@formatter:on*/
}
