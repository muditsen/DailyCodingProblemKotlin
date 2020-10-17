package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.Helper

/***
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
 * [5, 1, 1, 5] should return 10, since we pick 5 and 5.
 */
class Day9 : Test {

    override fun runTest() {
        println(maxSum(intArrayOf(2, 4, 6, 2, 5), 0))
        val dp1 = IntArray(6) {
            -1
        }

        println(dp1(intArrayOf(2, 4, 6, 2, 5), 0, dp1))
        Helper.printArr(dp1)
        Helper.printArr(intArrayOf(2, 4, 6, 2, 5))
        println("Dp2: " + dp2(intArrayOf(5,1,1,5)))
        println("Dp2: " + dp2(intArrayOf(2, 4, 6, 2, 5)))
    }

    private fun maxSum(arr: IntArray, pos: Int): Int {
        if (pos > arr.size - 1) {
            return 0
        }
        return Math.max(arr[pos] + maxSum(arr, pos + 2), maxSum(arr, pos + 1))
    }

    private fun dp1(arr: IntArray, pos: Int, dp: IntArray): Int {
        if (pos > arr.size - 1) {
            return 0
        }
        if (dp[pos] > -1) {
            return dp[pos]
        }
        dp[pos] = Math.max(arr[pos] + dp1(arr, pos + 2, dp), dp1(arr, pos + 1, dp))
        return dp[pos]
    }

    private fun dp2(arr: IntArray): Int {
        val intArr = IntArray(arr.size + 3) {
            0
        }
        for (i in arr.indices) {
            intArr[i + 3] = Math.max(arr[i] + intArr[i], arr[i] + intArr[i + 1])
            Helper.printArr(intArr)
        }

        return Math.max(intArr.last(), intArr[intArr.size - 2])
    }
}