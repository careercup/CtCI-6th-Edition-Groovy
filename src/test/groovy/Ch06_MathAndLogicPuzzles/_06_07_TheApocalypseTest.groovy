package Ch06_MathAndLogicPuzzles

import spock.lang.Specification
import spock.lang.Unroll

import static Ch06_MathAndLogicPuzzles._06_07_TheApocalypse.ratio
import static java.lang.Math.abs

@Unroll class _06_07_TheApocalypseTest extends Specification {
    /*@formatter:off*/
    def 'theApocalypse?'() {
        expect: (500..1000).each { familyCount -> 
                    def result = ratio(familyCount)
                    assert abs(result - 1) < 2/10
                }
    }
    /*@formatter:on*/
}
