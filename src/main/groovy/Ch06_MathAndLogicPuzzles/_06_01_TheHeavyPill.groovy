package Ch06_MathAndLogicPuzzles

/** Given bottles of pills, find the one that has heavier pill with one weighing */
class _06_01_TheHeavyPill {
    /** Complexity: O(bottles.count**2) */
    static index(List<Number> bottleWeights, Number normalWeight, Number differentWeight) {
        def sumWeightDifference = (actualWeight(bottleWeights) - expectedWeight(bottleWeights, normalWeight))
        def pillWeightDifference = (differentWeight - normalWeight)
        (sumWeightDifference / pillWeightDifference) - 1
    }
    private static actualWeight(List<Number> values) {
        values.indexed().collect { i, value ->
            (i + 1) * value
        }.sum()
    }
    private static expectedWeight(List<Number> values, Number weight) {
        weight * (values.size() * (values.size() + 1)) / 2
    }
}