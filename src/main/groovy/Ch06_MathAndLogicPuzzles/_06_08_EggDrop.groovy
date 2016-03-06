package Ch06_MathAndLogicPuzzles

import static java.lang.Math.max
import static java.lang.Math.sqrt

/** You are given two identical eggs to find out from which floor of a tall building they would break */
class _06_08_EggDrop {
    static dropCount(int floorCount, Closure<Boolean> breaks) {
        def increment = max(2, (sqrt(1 + 8 * floorCount) - 1) / 2) // x * (x + 1) / 2 = floorCount 
        def floor = increment
        while (floor < floorCount && !breaks(floor as int))
            floor += --increment

        floor = (floor - increment + 1) as int
        while (floor <= floorCount && !breaks(floor))
            floor++

        (floor > floorCount) ? Integer.MAX_VALUE
                             : floor
    }
}