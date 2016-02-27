package Ch05_BitManipulation

import spock.lang.Specification
import spock.lang.Unroll

import static Ch05_BitManipulation._05_08_DrawLine.drawLine

@Unroll class _05_08_DrawLineTest extends Specification {
    /*@formatter:off*/
    def 'drawLine?'() {
        when:   def screen = new byte[byteWidth * bitHeight] 
        then:   drawLine(screen, byteWidth, x1, x2, y) == (byte[]) result
        where:  byteWidth | bitHeight | x1 | x2 | y || result 
                1         | 1         | 2  | 5  | 0 || [0b00111100]   
                2         | 1         | 13 | 15 | 0 || [0,0b00000111]   
                2         | 1         | 2  | 10 | 0 || [0b00111111,0b11100000]   
                3         | 1         | 14 | 18 | 0 || [0,0b00000011,0b11100000]   

                3         | 3         | 2  | 18 | 0 || [0b00111111,~0,0b11100000,0,0,0,0,0,0]   
                3         | 3         | 1  | 20 | 1 || [0,0,0,0b01111111,~0,0b11111000,0,0,0]   
                3         | 3         | 0  | 23 | 2 || [0,0,0,0,0,0,~0,~0,~0]
    }
    /*@formatter:on*/
}
