package Ch06_MathAndLogicPuzzles

import spock.lang.Specification
import spock.lang.Unroll

import static Ch06_MathAndLogicPuzzles._06_02_Basketball.probability

@Unroll class _06_02_BasketballTest extends Specification {
    /*@formatter:off*/
    def 'basketball: successCount / shotCount?'() {
        expect: for (shotCount in 1..7)
                    for (successCount in 0..shotCount)
                        assert probability(shotCount, successCount) == simulatedProbability(shotCount, successCount)
    }
    /*@formatter:on*/

    static simulatedProbability(int shotCount, int successCount) {
        def allCombinations = (0..shotCount).collectMany { ([true] * it + [false] * (shotCount - it)).permutations() }
        def correctCombinations = allCombinations.findAll { it.count(true) >= successCount }
        correctCombinations.size() / allCombinations.size()
    }
}
