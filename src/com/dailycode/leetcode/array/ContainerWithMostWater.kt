package com.dailycode.leetcode.array

import com.dailycode.Test

class ContainerWithMostWater : Test {
    override fun runTest() {
        println("Test case 1: " + maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
        println("Test case 2: " + maxArea(intArrayOf(1, 1)))
        println("Test case 3: " + maxArea(intArrayOf(4, 3, 2, 1, 4)))
        println("Test case 4: " + maxArea(intArrayOf(1, 2, 1)))
        println("Test case 5: " + maxArea(intArrayOf()))
    }

    fun maxArea(height: IntArray): Int {
        if (height.isEmpty() || height.size == 1) {
            return 0
        }
        var i = 0
        var j = height.size - 1
        var area = 0
        var maxArea = 0
        while (i < j) {
            if (height[i] < height[j]) {
                area = height[i] * (j - i)
                i++
            } else {
                area = height[j] * (j - i)
                j--
            }
            if (maxArea < area) {
                maxArea = area
            }
        }
        return maxArea
    }

}