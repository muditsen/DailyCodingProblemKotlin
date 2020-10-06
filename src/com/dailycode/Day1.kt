package com.dailycode

/***
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 */
class Day1 : Test {

    override fun runTest() {
        println(solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13), 30))
    }

    private fun solution(arr: IntArray, k: Int): Pair<Int, Int> {
        val setOfInt = HashSet<Int>()
        for (n in arr) {
            if (setOfInt.contains(k - n)) {
                return Pair(k - n, n)
            } else {
                setOfInt.add(n)
            }
        }
        return Pair(0, 0)
    }
}