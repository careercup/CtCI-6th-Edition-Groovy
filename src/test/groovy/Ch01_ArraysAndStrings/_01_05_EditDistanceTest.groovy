package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static _01_05_EditDistance.isCloseEnough

@Unroll class _01_05_EditDistanceTest extends Specification {
    /*@formatter:off*/
    def 'isCloseEnough?'() {
        expect: isCloseEnough(a, b) == isCloseEnough
        where:  a       | b      || isCloseEnough
                ''      | 'a'    || true
                'a'     | ''     || true
                'pale'  | 'pale' || true
                'pale'  | 'ale'  || true
                'pale'  | 'ple'  || true
                'pale'  | 'pae'  || true
                'pale'  | 'pal'  || true
                'pales' | 'pale' || true

                'pale'  | 'bale' || true
                'pale'  | 'pala' || true

                'pale'  | 'bake' || false
                'pale'  | 'pa'   || false
                'pa'    | 'pale' || false
    }
    /*@formatter:on*/
}
