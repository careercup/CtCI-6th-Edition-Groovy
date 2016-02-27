package Ch05_BitManipulation

import spock.lang.Specification
import spock.lang.Unroll

import static Ch05_BitManipulation._05_01_Insertion.merge

@Unroll class _05_01_InsertionTest extends Specification {
    /*@formatter:off*/
    def 'merge of #source and #target is #result?'(int source, int target, IntRange range, int result) {
        expect: merge(source, target, range) == result
        where:  source              | target   | range  || result
                0b1111              | 0b10     | 0..3   || 0b10
                0b1101              | 0b10     | 1..3   || 0b101
                0b10011111100       | 0b110011 | 2..6   || 0b10011001100
                0b11001001100110001 | 0b1101   | 4..12  || 0b11000000011010001
                ~0                  | 0b1101   | 4..12  || 0b11111111111111111110000011011111
    }
    /*@formatter:on*/
}
