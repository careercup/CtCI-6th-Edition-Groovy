package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static _01_03_URLify.urlify

@Unroll class _01_03_URLifyTest extends Specification {
    /*@formatter:off*/
    def 'URLify?'() {
        when:   def expected = string[0..<length].replace(search, replacement)
                def actual = urlify(string, length, search, replacement)
        then:   actual == expected
        where:  string              | length | search | replacement
                'xyx'               | 3      | 'x'    | 'y'
                'xyyx  '            | 4      | 'yy'   | 'yyyy'
                'Mr John Smith    ' | 13     | ' '    | '%20'
                'aabbccddccbbaa'    | 14     | 'bb'   | '**'
                'abcabcbacbacba'    | 14     | 'ba'   | '**'
    }
    /*@formatter:on*/
}
