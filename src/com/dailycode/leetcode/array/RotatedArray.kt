package com.dailycode.leetcode.array

import com.dailycode.Test

class RotatedArray : Test {
    override fun runTest() {
        /*println(findMin(intArrayOf(11,13,15,17)))
        println(findMin(intArrayOf(4,5,6,7,0,1,2)))
        println(findMin(intArrayOf(3,4,5,1,2)))
        println(findMin(intArrayOf(2, 1)))
        println(findMin(intArrayOf(1)))
        println(findMin(intArrayOf(2,2,2,0,1)))*/
        println(findMin(intArrayOf(2,2,2,2,0,0,0,0,1)))
    }

    fun findMin(nums: IntArray): Int {
        return nums[findMinHelper(nums, 0, nums.size - 1)]
    }

    fun check(nums: IntArray, mid: Int): Boolean {
        if(nums.size == 1 || nums.size == 0){
            return true
        }
        return if (mid - 1 < 0) {
            nums[mid] <= nums[mid + 1]
        } else if (mid+1 >= nums.size) {
            nums[mid] <= nums[mid - 1]
        }else{
            nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1]
        }

    }

    fun findMinHelper(nums: IntArray, left: Int, right: Int): Int {
        val mid = (right + left) / 2
        if (check(nums, mid)) {
            return mid
        }
        println("${nums[left]} ${nums[mid]} ${nums[right]}")
        if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
            return findMinHelper(nums, mid + 1, right)
        } else {
            return findMinHelper(nums, left, mid - 1)
        }
    }

}