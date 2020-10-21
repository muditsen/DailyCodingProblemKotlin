package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.Helper

/***
 *
 * There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time.
 * Given N, write a function that returns the number of unique ways you can climb the staircase.
 * The order of the steps matters.
 *
 */
class Day12 : Test {
    override fun runTest() {
        println(solution(11))
        var intArray = IntArray(12) {
            0
        }
        println(dp1(11, intArray))
        Helper.printArr(intArray)

        println(dp2(5))
        println()
        println()
        println()

        println(solution2(10))
        intArray = IntArray(11) {
            0
        }

        println(s2dp2(10, intArray))
        Helper.printArr(intArray)
        println(s2dp3(10))


    }

    private fun solution(n: Int): Int {
        if (n == 0) {
            return 1
        }
        if (n < 0) {
            return 0
        }
        return solution(n - 1) + solution(n - 2)
    }

    private fun dp1(n: Int, dp: IntArray): Int {
        if (n == 0) {
            return 1
        }
        if (n < 0) {
            return 0
        }
        if (dp[n] > 0) {
            return dp[n]
        }
        dp[n] = dp1(n - 1, dp) + dp1(n - 2, dp)
        return dp[n]
    }

    private fun dp2(n: Int): Int {
        var ans = 0
        var n1 = 0
        var n2 = 1
        for (i in 1..n) {
            ans = n1 + n2
            n1 = n2
            n2 = ans
        }
        return ans
    }

    /***
     *What if, instead of being able to climb 1 or 2 steps at a time,
     *you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5},
     *you could climb 1, 3, or 5 steps at a time.
     */

    private fun solution2(n: Int): Int {
        if (n == 0) {
            return 1
        }
        if (n < 0) {
            return 0
        }
        return solution2(n - 1) + solution2(n - 3) + solution2(n - 5)
    }

    private fun s2dp2(n: Int, dp: IntArray): Int {
        if (n == 0) {
            return 1
        }
        if (n < 0) {
            return 0
        }
        if (dp[n] > 0) {
            return dp[n]
        }
        dp[n] = s2dp2(n - 1, dp) + s2dp2(n - 3, dp) + s2dp2(n - 5, dp)
        return dp[n]
    }

    private fun s2dp3(n: Int): Int {
        val intArray = IntArray(n + 1) {
            0
        }
        intArray[0] = 1
        intArray[1] = 1
        for (i in 2..n) {
            intArray[i] = intArray[i - 1]
            if (i >= 3) {
                intArray[i] += intArray[i - 3]
            }
            if (i >= 5) {
                intArray[i] += intArray[i - 5]
            }
        }
        Helper.printArr(intArray)
        return intArray.last()
    }

}