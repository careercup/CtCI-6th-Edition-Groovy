package Ch06_MathAndLogicPuzzles

/** Given closed lockers, by opening everyone, closing every second, opening every third, etc, which lockers will be open at the end? */
class _06_09_Lockers {
    static openLockers(int lockerCount) {
        def results = new BitSet()

        def lockerRange = 0..lockerCount
        for (step in lockerRange)
            lockerRange.step(step + 1) { results.flip(it) }

        results.stream().collect()
    }
}