package Ch06_MathAndLogicPuzzles

import static Ch06_MathAndLogicPuzzles._06_07_TheApocalypse.Gender.FEMALE

/** What would be the ratio of men/women, if people would stop having children immediately after having a girl? 
 * 1/2 would have 1 girl
 * 1/4 would have 1 boy and 1 girl
 * 1/8 would have 2 boys and 1 girl
 * 1/16 would have 3 boys and 1 girl
 * ...
 * boy/girl ratio = 0/2 + 1/4 + 2/8 + 3/16 + ... (n-1)/2**n == 1 for n→∞  
 * */
class _06_07_TheApocalypse {
    static ratio(int familyCount) {
        def (males, females) = [familyCount, familyCount]
        (1..familyCount).each {
            while (Gender.random != FEMALE)
                males++
            females++
        }
        males / females
    }

    private static enum Gender {
        MALE, FEMALE

        private static rand = new Random()
        static getRandom() {
            def genders = values()
            genders[rand.nextInt(genders.size())]
        }
    }
}