package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.BinaryMaxHeap
import com.dailycode.helper.Helper
import kotlin.math.abs
import kotlin.random.Random

/***
 *
 * Given an array of integers and a number k, where 1 <= k <= length of the array,
 * compute the maximum values of each subarray of length k.
 *
 */
class Day18 : Test {

    override fun runTest() {
        /*val heap = BinaryMaxHeap()
        heap.insert(10)
        println(heap.top())
        Helper.printArr(heap.list)
        println()
        heap.insert(5)
        println(heap.top())
        Helper.printArr(heap.list)
        println()
        heap.insert(2)
        println(heap.top())
        Helper.printArr(heap.list)
        println()
        heap.insert(7)
        println(heap.top())
        Helper.printArr(heap.list)
        println()
        heap.insert(4)
        println(heap.top())
        Helper.printArr(heap.list)
        println()
        heap.insert(12)
        println(heap.top())
        Helper.printArr(heap.list)
        println()
        heap.insert(15)
        println(heap.top())
        Helper.printArr(heap.list)

        println()
        println()
        println(heap.remove())
        Helper.printArr(heap.list)

        println(heap.remove())
        Helper.printArr(heap.list)

        println(heap.remove())
        Helper.printArr(heap.list)


        println(heap.remove())
        Helper.printArr(heap.list)


        println(heap.remove())
        Helper.printArr(heap.list)


        println(heap.remove())
        Helper.printArr(heap.list)


        println(heap.remove())
        Helper.printArr(heap.list)*/


        /*solution(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        solution(intArrayOf(8, 5, 10, 7, 9, 4, 15, 12, 90, 13), 4)
        solution(intArrayOf(1, 2, 3, 1, 4, 5, 2, 3, 6), 3)*/
        /*val arr = IntArray(25) {
            abs(Random.nextInt() % 25)
        }
        Helper.printArr(arr)
        solution(arr, 3)*/
        solution(intArrayOf(8, 5, 10, 7, 6, 4, 2, 12, 90, 13), 4)
        //solution(intArrayOf(8, 5, 10, 7, 9, 4, 15, 12, 90, 13), 5)
        //solution(intArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1), 3)
    }

    //With O(n) time and O(n) space.
    private fun solution(intArray: IntArray, k: Int) {
        val heap = BinaryMaxHeap()
        for (i in 0 until k) {
            heap.insert(intArray[i])
        }
        println(heap.top())
        for (i in k until intArray.size) {
            //Helper.printArr(heap.list)
            heap.remove(intArray[i - k])
            if (heap.list.size > 0 && heap.top() < intArray[i]) {
                heap.list.clear()
            }
            heap.insert(intArray[i])
            println(heap.top())
        }
        println()
    }

}