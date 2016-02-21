package Ch01_ArraysAndStrings

import spock.lang.Specification
import spock.lang.Unroll

import static _01_09_StringRotation.isRotation

@Unroll class _01_09_StringRotationTest extends Specification {
    /*@formatter:off*/
    def 'rotate?'() {
        expect: isRotation(source, target) == result
        where:  source        | target        || result
                ''            | ''            || true
                'a'           | 'a'           || true
                'waterbottle' | 'erbottlewat' || true
                'apple'       | 'pleap'       || true

                'ab'          | 'aba'         || false
                'camera'      | 'macera'      || false
    }
    /*@formatter:on*/
}