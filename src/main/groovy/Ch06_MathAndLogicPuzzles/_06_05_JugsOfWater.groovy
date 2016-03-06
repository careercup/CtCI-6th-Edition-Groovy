package Ch06_MathAndLogicPuzzles

import static java.lang.Math.max
import static java.lang.Math.min

/** Given two jugs of known size, measure a given amount of water */
class _06_05_JugsOfWater {
    /** Complexity: O(firstJugSize * secondJugSize) 
     * Breadth first search the tree of possibilities to find the paths with the shortest height */
    static combinations(int firstJugSize, int secondJugSize, int targetSize) {
        def (results, remaining, visited) = [[] as Set, [[[0, 0]]] as ArrayDeque, [] as Set]
        while (!remaining.empty) {
            def history = remaining.removeFirst()
            def (first, second) = history.last()
            if ([first, second, first + second].any { it == targetSize })
                results << history
            else {
                def possibilities = possibilities(firstJugSize, first, secondJugSize, second)
                for (step in possibilities.findAll { visited.add(it) })
                    remaining.addLast(history + [step])
            }
        }

        results
    }
    protected static possibilities(int firstJugSize, int first, int secondJugSize, int second) {
        int total = first + second
        def (firstTotal, secondTotal) = [min(total, firstJugSize), min(total, secondJugSize)]
        [[0, second],                                 /* empty first */
         [firstJugSize, second],                      /* fill first */
         [firstTotal, 0],                             /* second → first, with overflow */
         [firstTotal, max(0, total - firstJugSize)],  /* second → first */

         [first, 0],                                   /* empty second */
         [first, secondJugSize],                       /* fill second */
         [0, secondTotal],                             /* second → first, with overflow */
         [max(0, total - secondJugSize), secondTotal], /* second → first */
        ].toSet().sort()
    }
}