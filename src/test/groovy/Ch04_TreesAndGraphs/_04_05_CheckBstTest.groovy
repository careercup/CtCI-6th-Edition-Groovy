package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNodeBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static _04_05_CheckBst.isBst

@Unroll class _04_05_CheckBstTest extends Specification {
    /*@formatter:off*/
    def 'isBst from #tree?'() {
        when:   def bst = BiNodeBuilder.from(tree)
        then:   isBst(bst) == result

        where:
        tree                                                              || result
        [0:[]]                                                            || true
        [1:[0]]                                                           || true
        [1:[0,2]]                                                         || true
        [2:[1,3],1:0]                                                     || true
        [2:[1,4],1:0,4:3]                                                 || true
        [3:[1,5],1:[0,2],5:4]                                             || true
        [3:[1,5],1:[0,2],5:[4,6]]                                         || true
        [4:[2,6],2:[1,3],1:0,6:[5,7]]                                     || true
        [12:[1,13],1:[0,6],6:[3,9],3:[2,5],9:[8,10],5:4,8:7,10:[null,11]] || true


        [1:2]                                                             || false
        [1:[null,0]]                                                      || false
        [1:[2,0]]                                                         || false
        [2:[1,3],1:5]                                                     || false
        [2:[3,1],1:[0,4]]                                                 || false
        [3:[1,6],1:[0,2],6:[5,4]]                                         || false
    }
    /*@formatter:on*/
}
