package Ch04_TreesAndGraphs

import Ch04_TreesAndGraphs.utils.BiNodeBuilder
import spock.lang.Specification
import spock.lang.Unroll

import static Ch04_TreesAndGraphs._04_06_SuccessorTest.collectNodes
import static Ch04_TreesAndGraphs._04_10_CheckSubtree.contains_withBfs
import static Ch04_TreesAndGraphs._04_10_CheckSubtree.contains_withHash

@Unroll class _04_10_CheckSubtreeTest extends Specification {
    /*@formatter:off*/
    def 'containsTree from #tree?'() {
        when:   def roots = collectNodes(BiNodeBuilder.from(tree))
        then:   for (source in roots)
                    for (target in collectNodes(source)) {
                        assert contains_withHash(source, target) 
                        assert contains_withBfs(source, target)
                        
                        if (!source.is(target)){
                            assert !contains_withHash(target, source) 
                            assert !contains_withBfs(target, source)
                        }
                    }
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
