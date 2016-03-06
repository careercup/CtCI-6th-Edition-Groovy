package Ch06_MathAndLogicPuzzles

import groovy.transform.Memoized

/** Calculate the probability of making a given number of basketball shots */
class _06_02_Basketball {
    /** Complexity: O(shotCount - successCount) */
    static probability(int shotCount, int successCount) {
        def all = 2**shotCount
        def successful = (successCount..shotCount).sum(0) { int count ->
            factorial(shotCount) / (factorial(count) * factorial(shotCount - count))
        }
        successful / all
    }

    @Memoized private static factorial(int num) {
        if (num < 0) throw new IllegalArgumentException()
        else if (num == 0) 1
        else num * factorial(num - 1)
    }
}