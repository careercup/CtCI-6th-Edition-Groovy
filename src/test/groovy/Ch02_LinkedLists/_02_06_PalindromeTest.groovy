package Ch02_LinkedLists

import Ch02_LinkedLists.utils.Node
import spock.lang.Specification
import spock.lang.Unroll

import static _02_06_Palindrome.isPalindrome_withStack

@Unroll class _02_06_PalindromeTest extends Specification {
    /*@formatter:off*/
    def 'palindrome?'() {
        when:   def head = Node.from(values.toList())
        then:   isPalindrome_withStack(head) == verdict
        where:  values      || verdict
                [1]         || true
                [1,1]       || true
                [1,2,1]     || true
                [1,2,2,1]   || true
                [1,2,3,2,1] || true
                'racecar'   || true

                [2,1]       || false
    }
    /*@formatter:on*/
}
