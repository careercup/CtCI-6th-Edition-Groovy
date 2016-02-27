package Ch05_BitManipulation

import spock.lang.Specification
import spock.lang.Unroll

import static Ch05_BitManipulation._05_06_Conversion.differences

@Unroll class _05_06_ConversionTest extends Specification {
    /*@formatter:off*/
    def '#souce and #target have #count differences?'() {
        expect: differences(source, target) == count 
        where:  source  | target  || count
                0b0000  | 0b0000  || 0
                0b0101  | 0b0111  || 1
                0b1111  | 0b0101  || 2
                0b0101  | 0b0010  || 3
                0b1111  | 0b0000  || 4
                
                0b11101 | 0b01111 || 2
    }
    /*@formatter:on*/
}
