package com.dailycode.leetcode

import com.dailycode.Test

class MedianOfTwoSortedArray : Test {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val nums = IntArray(nums1.size + nums2.size)
        var i = 0
        var j = 0
        var k = 0
        while (i < nums1.size && j < nums2.size) {
            nums[k++] = if (nums1[i] > nums2[j]) {
                nums2[j++]
            } else {
                nums1[i++]
            }

        }
        while (i < nums1.size) {
            nums[k] = nums1[i]
            i++
            k++

        }
        while (j < nums2.size) {
            nums[k] = nums2[j]
            j++
            k++
        }

        return if(nums.size % 2 == 0){
            (nums[(nums.size/2)] + nums[((nums.size/2) + 1)].toDouble()) / 2
        }else{
            nums[(nums.size/2)].toDouble()
        }
    }

    override fun runTest() {
        println(findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    }
}