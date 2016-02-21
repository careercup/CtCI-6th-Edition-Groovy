package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node
import spock.lang.Specification
import spock.lang.Unroll

import static _02_01_FindDuplicates.removeDuplicates
import static java.lang.Math.E
import static java.lang.Math.PI

@Unroll class _02_01_FindDuplicatesTest extends Specification {
    /*@formatter:off*/
    def 'removeDuplicates?'() {
        when:   def head = Node.from(source)
                def unique = removeDuplicates(head).toList()
        then:   unique.sort() == source.toSet().sort()
        where:  source    | _
                []        | _
                [1]       | _
                [1,2]     | _
                [1,1]     | _
                [1,2,2,1] | _
                [1,2,1,2] | _
                [1,1,2,2] | _
                "$PI"     | _
                "$E"      | _
    }
    /*@formatter:on*/
}
