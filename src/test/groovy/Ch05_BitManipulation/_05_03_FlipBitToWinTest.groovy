package Ch05_BitManipulation

import spock.lang.Specification
import spock.lang.Unroll

import static Ch05_BitManipulation._05_03_FlipBitToWin.maxSequence

@Unroll class _05_03_FlipBitToWinTest extends Specification {
    /*@formatter:off*/
    def 'maxSequence #source is #result?'() {
        expect: maxSequence(source) == result
        where:  source        || result
                0b0           || 1 
                0b1           || 2 
                0b10          || 2 
                0b11          || 3 
                0b100         || 2 
                0b101         || 3 
                0b110         || 3 
                0b111         || 4 
                0b1000        || 2 
                0b1001        || 2 
                0b1010        || 3 
                0b1011        || 4 
                0b1100        || 3 
                0b1101        || 4 
                0b1111        || 5
        
                0b110001      || 3 
                0b11011101111 || 8 
                ~0            || 32 
    }
    /*@formatter:on*/
}
