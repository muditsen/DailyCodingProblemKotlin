package com.dailycode.leetcode

import com.dailycode.Test

class RainWaterHarvesting : Test {
    override fun runTest() {
        println(solution(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
        println(solution(intArrayOf(4, 2, 0, 3, 2, 5)))
        /*println(solution(intArrayOf(1, 2, 3, 5, 6, 7, 8, 9)))
        println(solution(intArrayOf(5, 4, 3, 2, 1)))*/
        println(solution(intArrayOf(4,2,3)))

    }

    fun solution(height: IntArray): Int {
        if (height.isEmpty()) {
            return 0
        }
        var i = 0
        val n = height.size
        while (i < n && height[i] == 0) {
            i++
        }
        var count = 0
        while (i < n) {
            var j = i + 1

            while (j < n && height[j] < height[i]) {
                j++
            }
            // println("$i and $j")
            //Container is created
            if (j < n) {
                var k = i
                while (k < j) {
                    val diff = height[i] - height[k]
                    count += (if (diff > 0) diff else 0)
                    k++
                }
                i = j
            } else {
                i++
            }
        }
        return count
    }

    override fun getName(): String {
        return this::class.java.simpleName
    }

}