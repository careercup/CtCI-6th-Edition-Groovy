package Ch06_MathAndLogicPuzzles

import spock.lang.Specification
import spock.lang.Unroll

import static Ch06_MathAndLogicPuzzles._06_05_JugsOfWater.combinations
import static Ch06_MathAndLogicPuzzles._06_05_JugsOfWater.possibilities

@Unroll class _06_05_JugsOfWaterTest extends Specification {
    /*@formatter:off*/
    def 'JugsOfWater: #firstJugSizeSize & #secondJugSize -> #targetSize?'() {
        expect: combinations(firstJugSizeSize, secondJugSize, targetSize)*.last() as Set == results as Set
        where:  firstJugSizeSize | secondJugSize | targetSize || results
                1                | 1             | 1          || [[0,1],[1,0]]        
                1                | 1             | 2          || [[1,1]]        
                1                | 1             | 3          || []        
                3                | 3             | 1          || []        
                
                5                | 3             | 4          || [[1,3],[4,3]]        
                5                | 7             | 4          || [[4,7],[5,4]]        
                5                | 7             | 3          || [[3,7],[5,3]]        
                3                | 7             | 4          || [[3,1],[3,4]]        
    }

    def 'History of JugsOfWater: #firstJugSizeSize & #secondJugSize -> #targetSize?'() {
        expect: combinations(firstJugSizeSize, secondJugSize, targetSize) == results as Set
        where:  firstJugSizeSize | secondJugSize | targetSize || results
                1                | 1             | 1          || [[[0,0],[0,1]],[[0,0],[1,0]]]        
                5                | 3             | 4          || [[[0,0],[0,3],[3,0],[3,3],[5,1],[0,1],[1,0],[1,3]],[[0,0],[5,0],[2,3],[2,0],[0,2],[5,2],[4,3]]]        
    }
    
    def 'possibilities: #firstJugSizeSize, #first, #secondJugSize, #second?'() {
        expect: possibilities(firstJugSizeSize, first, secondJugSize, second) == results.toSet().sort()
        where:  firstJugSizeSize | first | secondJugSize | second || results
                5                | 0     | 3             | 0      || [[0,0],[0,3],[5,0]]        
                30               | 29    | 3             | 2      || [[0,2],[0,3],[28,3],[29,0],[29,3],[30,0],[30,1],[30,2]]      
                30               | 1     | 3             | 1      || [[0,1],[0,2],[1,0],[1,3],[2,0],[30,1]]      
        
    }
    /*@formatter:on*/
}
