package Ch06_MathAndLogicPuzzles

import spock.lang.Specification
import spock.lang.Unroll

import static Ch06_MathAndLogicPuzzles._06_09_Lockers.openLockers
import static java.lang.Math.sqrt

@Unroll class _06_09_LockersTest extends Specification {
    /*@formatter:off*/
    def 'lockers?'() {
        expect: openLockers(lockerCount) == result
        where:  lockerCount || result
                100         || (0..sqrt(lockerCount)).collect{ it**2 }        
    }
    /*@formatter:on*/
}
