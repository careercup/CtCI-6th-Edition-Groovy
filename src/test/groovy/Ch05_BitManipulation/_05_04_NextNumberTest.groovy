package Ch05_BitManipulation

import spock.lang.Specification
import spock.lang.Unroll

import static Ch05_BitManipulation._05_04_NextNumber.getNext
import static Ch05_BitManipulation._05_04_NextNumber.getPrevious

@Unroll class _05_04_NextNumberTest extends Specification {
    /*@formatter:off*/
    def '#source previous, next is #previous, #next?'() {
        expect: getPrevious(source) == previous
        and:    getNext(source) == next
            
        where:  source   || previous || next
                0b00000  || 0b00000  || 0b000000
                0b00001  || 0b00001  || 0b000010
                0b00010  || 0b00001  || 0b000100
                0b00011  || 0b00011  || 0b000101
                0b00100  || 0b00010  || 0b001000
                0b00101  || 0b00011  || 0b000110
                0b00110  || 0b00101  || 0b001001
                0b00111  || 0b00111  || 0b001011
                0b01000  || 0b00100  || 0b010000
                0b01001  || 0b00110  || 0b001010
                0b01010  || 0b01001  || 0b001100
                0b01011  || 0b00111  || 0b001101
                0b01100  || 0b01010  || 0b010001
                0b01101  || 0b01011  || 0b001110
                0b01110  || 0b01101  || 0b010011
                0b01111  || 0b01111  || 0b010111
                0b10000  || 0b01000  || 0b100000
                
                ~0 >> 1  || ~0 >> 1  || ~0 >> 1
    }
    /*@formatter:on*/
}
