package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNodeBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static _04_04_CheckBalanced.isBalanced

@Unroll class _04_04_CheckBalancedTest extends Specification {
    /*@formatter:off*/
    def 'isBalanced from #tree?'() {
        when:   def bst = BiNodeBuilder.from(tree)
        then:   isBalanced(bst) == result

        where:
        tree                                                              || result
        [0:[]]                                                            || true
        [1:[0]]                                                           || true
        [1:[0,2]]                                                         || true
        [2:[1,3],1:0]                                                     || true
        [2:[1,3],1:[0,4]]                                                 || true
        [2:[1,4],1:0,4:3]                                                 || true
        [3:[1,5],1:[0,2],5:4]                                             || true
        [3:[1,5],1:[0,2],5:[4,6]]                                         || true
        [4:[2,6],2:[1,3],1:0,6:[5,7]]                                     || true

        [2:1,1:0]                                                         || false
        [2:[null,1],1:[null,0]]                                           || false
        [2:[1,3],1:[0,4],0:5]                                             || false
        [4:[2,6],2:[1,3],1:0]                                             || false
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:[null,11]] || false
    }
    /*@formatter:on*/
}
