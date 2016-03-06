package Ch06_MathAndLogicPuzzles

import spock.lang.Specification

import static Ch06_MathAndLogicPuzzles._06_08_EggDrop.dropCount

class _06_08_EggDropTest extends Specification {
    /*@formatter:off*/
    def 'eggDrop?'() {
        expect:  for (floorCount in 1..100) {
                    assert dropCount(floorCount) { false } == Integer.MAX_VALUE 
                    for (breakingFloor in 1..floorCount)
                        assert dropCount(floorCount) { it >= breakingFloor } == breakingFloor 
                }
    }
    /*@formatter:on*/
}
