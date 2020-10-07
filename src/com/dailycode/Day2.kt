package com.dailycode

/***
 *
 * Given an array of integers, return a new array such that each element at index i
 * of the new array is the product of all the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5],
 * the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1],
 * the expected output would be [2, 3, 6].
 *
 ****/
class Day2 : Test {

    override fun runTest() {
        solution1(intArrayOf(3, 2, 1))
        solution2(intArrayOf(3, 2, 1))

        solution1(intArrayOf(1,2,3,4,5))
        solution2(intArrayOf(1,2,3,4,5))

        solution1(intArrayOf(12,34,15,56,17,80,32))
        solution2(intArrayOf(12,34,15,56,17,80,32))
    }

    private fun solution1(arr: IntArray) {
        var product = 1L
        for (n in arr) {
            product *= n
        }

        println()
        for (n in arr) {
            print("${product / n}\t")
        }
    }

    /***
     * Follow-up: what if you can't use division?
     ****/
    private fun solution2(arr: IntArray) {

        val cumulativeFwd = IntArray(arr.size)
        val cumulativeBack = IntArray(arr.size)

        cumulativeFwd[0] = arr[0]
        for(i in 1 until arr.size){
            cumulativeFwd[i] = arr[i] * cumulativeFwd[i-1]
        }

        cumulativeBack[arr.size-1] = arr[arr.size-1]
        for(i in arr.size-2 downTo 0){
            cumulativeBack[i] = arr[i] * cumulativeBack[i+1]
        }

        val solution = IntArray(arr.size)
        solution[0] = cumulativeBack[1]
        solution[arr.size-1] = cumulativeFwd[arr.size-2]
        for(i in 1..arr.size-2){
            solution[i] = cumulativeBack[i+1] * cumulativeFwd[i-1]
        }

        println()
        for (n in solution) {
            print("${n}\t")
        }
    }

}