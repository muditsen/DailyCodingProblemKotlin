package com.dailycode.leetcode.array

import com.dailycode.Test
import com.dailycode.helper.Helper
import com.dailycode.printLog

class RemoveElement : Test {
    override fun runTest() {
        printLog(removeElement(`val` = 2, nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)))
        printLog(removeElement(`val` = 3, nums = intArrayOf(3, 2, 2, 3)))
        printLog(removeElement(`val` = 2, nums = intArrayOf(3, 2, 2, 3)))
        printLog(removeElement(`val` = 1, nums = intArrayOf(1)))
    }

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = 0
        var count = nums.size
        while (j < nums.size) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            if (nums[i] == `val`) {
                count--
                j++
            } else {
                i++
                j++
            }

        }
       // Helper.printArr(nums)
        return if (i != j) {
            count
        } else {
            nums.size
        }
    }
}