package Ch06_MathAndLogicPuzzles

/** Q: There are similar ants on each vertex of a polygon.
 *     What is the probability that if they start moving on the edges, some will collide? */

/** A: Nobody will collide, if they all move in the same direction: `2` possibilities.
 *     There are `2**n` possible combinations for collisions.
 *     They will collide with probability `1 - (1 / 2**(n - 1))`
 */
