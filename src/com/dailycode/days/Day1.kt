package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.Helper

/***
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 */
class Day1 : Test {

    override fun runTest() {
        println(solution(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13), 30))
        val x = intArrayOf(1,0)
        Helper.printArr(x)
        segregate0and1For2(x,0)
        Helper.printArr(x)
    }

    private fun solution(arr: IntArray, k: Int): Pair<Int, Int> {
        val setOfInt = HashSet<Int>()
        for (n in arr) {
            if (setOfInt.contains(k - n)) {
                return Pair(k - n, n)
            } else {
                setOfInt.add(n)
            }
        }
        return Pair(0, 0)
    }

    fun segregate0And1While(intArray: IntArray) {
        var left = 0
        var right = intArray.size - 1
        var count = 0
        while (left < right) {
            while (intArray[left] == 0) {
                left++
                count++
            }
            while (intArray[right] == 1) {
                right--
                count++
            }
            if (left < right) {
                val temp = intArray[left]
                intArray[left] = intArray[right]
                intArray[right] = temp
                left++
                right--
            }
        }
    }

    fun segregate0and1For(intArray: IntArray) {
        var j = 0
        for (i in intArray.indices) {
            if (intArray[i] == 0) {
                if (i != j) {
                    val temp = intArray[j]
                    intArray[j] = intArray[i]
                    intArray[i] = temp
                }
                j++
            }
        }
    }

    fun segregate0and1For2(intArray: IntArray,k:Int) {
        var j = 0
        for (i in intArray.indices) {
            if (intArray[i] <= k) {
                if (i != j) {
                    val temp = intArray[j]
                    intArray[j] = intArray[i]
                    intArray[i] = temp
                }
                j++
            }
        }
    }

    fun segregate0and1For2(intArray: IntArray) {
        var j = 0
        for (i in intArray.indices) {
            if (intArray[i] == 1) {
                val temp = intArray[j]
                intArray[j] = intArray[i]
                intArray[i] = temp
                j++
            }
        }
    }
}