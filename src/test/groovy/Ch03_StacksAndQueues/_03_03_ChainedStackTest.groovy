package Ch03_StacksAndQueues

import spock.lang.Specification

import static java.lang.Math.E
import static java.lang.Math.PI

class _03_03_ChainedStackTest extends Specification {
    /*@formatter:off*/
    def 'chainedStack?'() {
        given:  def source = "$PI$E".toList()

        when:   'a new stack is empty'
                def stack = new ChainedStack(5)
        then:   stack.empty

        when:   'consuming a stack yields the correct value'
                source.reverseEach {
                    stack.push(it)
                    assert !stack.empty
                }
        then:   source.each { assert it == stack.pop() }
                stack.empty
    }
    /*@formatter:on*/
}
