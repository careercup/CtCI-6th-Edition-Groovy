package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static _01_06_RunLengthEncoding.compress

@Unroll class _01_06_RunLengthEncodingTest extends Specification {
    /*@formatter:off*/
    def 'compress?'() {
        expect: compress(original) == compressed
        where:  original      || compressed
                ''            || ''
                'a'           || 'a'
                'aa'          || 'aa'
                'aaa'         || 'a3'
                'aaaa'        || 'a4'
                'aabcccccaaa' || 'a2b1c5a3'
    }
    /*@formatter:on*/
}
