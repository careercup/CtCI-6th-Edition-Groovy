package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node
import spock.lang.Specification
import spock.lang.Unroll

import static _02_03_DeleteNode.deleteNode
import static java.lang.Math.E
import static java.lang.Math.PI

@Unroll class _02_03_DeleteNodeTest extends Specification {
    /*@formatter:off*/
    def 'delete?'() {
        expect: source.eachWithIndex { _, int i ->
                    def reference = source.toList()
                    reference.remove(i)

                    def head = Node.from(source)
                    deleteNode(head, i)

                    assert head.toList() == reference
                }
        where:  source | _
                "$PI"  | _
                "$E"   | _
    }
    /*@formatter:on*/
}
