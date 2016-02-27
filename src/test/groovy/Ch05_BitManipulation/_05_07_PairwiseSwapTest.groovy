package Ch05_BitManipulation

import spock.lang.Specification
import spock.lang.Unroll

import static Ch05_BitManipulation._05_07_PairwiseSwap.swapOddEvenBits

@Unroll class _05_07_PairwiseSwapTest extends Specification {
    /*@formatter:off*/
    def 'swap #source == #target?'() {
        expect: swapOddEvenBits(source) == target 
        where:  source || target  
                0b0000 || 0b0000  
                0b0001 || 0b0010  
                0b0010 || 0b0001  
                0b0011 || 0b0011  
                0b0100 || 0b1000  
                0b0101 || 0b1010  
                0b0110 || 0b1001  
                0b0111 || 0b1011  
                0b1000 || 0b0100  
                0b1001 || 0b0110  
                0b1010 || 0b0101  
                0b1011 || 0b0111  
                0b1100 || 0b1100  
                0b1101 || 0b1110  
                0b1110 || 0b1101  
                0b1111 || 0b1111  
                
                0b1001010101001010 || 0b0110101010000101
    }
    /*@formatter:on*/
}
