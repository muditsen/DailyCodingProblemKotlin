package com.dailycode.leetcode.array

import com.dailycode.Test
import com.dailycode.helper.Helper
import kotlin.math.abs

class FirstMissingPositive : Test {
    override fun runTest() {
        println(firstMissingPositive(intArrayOf(3, 4, -1, 1)))
        println(firstMissingPositive(intArrayOf(1, 2, 0)))
        println(firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
        println(firstMissingPositive(intArrayOf(0, 0, 0, 0, 0)))
        println(firstMissingPositive(intArrayOf(1)))
        println(firstMissingPositive(intArrayOf(1,1,2,2,2,2,3,3,3,4)))
        println(firstMissingPositive(intArrayOf(0, 1, 2)))
        println(firstMissingPositive(intArrayOf(-5)))
    }

    fun firstMissingPositive(nums: IntArray): Int {
        var i = 0
        var j = 0

        while (i < nums.size) {
            if (nums[i] < 0) {
                nums[i] = 0
            }
            i++
        }
        i=0

        while (i < nums.size) {
            val tmp = nums[i]
            nums[i] = nums[j]
            nums[j] = tmp
            if (tmp > 0) {
                j++
            }
            i++
        }



        //Helper.printArr(nums)

        i = 0
        while (i < nums.size) {
            if (abs(nums[i]) <= nums.size) {
                if (nums[i] < 0) {
                    if (nums[-nums[i] - 1] > 0) {
                        nums[-nums[i] - 1] = -nums[-nums[i] - 1]
                    }
                } else if (nums[i] > 0) {
                    if (nums[nums[i] - 1] > 0) {
                        nums[nums[i] - 1] = -nums[nums[i] - 1]
                    }
                }
            }
            i++
        }

        i = 0
        while (i < nums.size) {
            if (nums[i] < 0) {
                i++
            } else {
                break
            }
        }

        //Helper.printArr(nums)
        return i + 1
    }

}