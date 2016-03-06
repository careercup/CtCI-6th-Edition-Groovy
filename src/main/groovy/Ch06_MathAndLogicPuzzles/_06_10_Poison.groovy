package Ch06_MathAndLogicPuzzles

/** You have bottles (from which 1 is poisoned) and poison detecting strips. 
 *  You can reuse strips, but it takes several days for a strip to show the results (contained poison or not).
 *  How long would it take to find the poison? */
class _06_10_Poison {
    static getPoisonedBottle(int bottleCount, Closure<List<Boolean>> test) {
        def strips = markStrips(bottleCount)
        def results = test(strips).collect { it ? 1 : 0 }
        Integer.valueOf(results.join(), 2)
    }

    private static markStrips(int bottleCount) {
        def strips = [].withDefault { [] }
        bottleCount.times { bottle ->
            for (strip in BitSet.valueOf(bottle).stream())
                strips[strip] += bottle
        }
        strips.reverse()
    }
}