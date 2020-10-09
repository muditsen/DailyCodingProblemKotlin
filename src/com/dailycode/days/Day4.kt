package com.dailycode.days

import com.dailycode.Test

/***
 *
 * Given an array of integers, find the first missing positive integer in linear time and constant space.
 * In other words, find the lowest positive integer that does not exist in the array.
 * The array can contain duplicates and negative numbers as well.
 */
class Day4 : Test {

    override fun runTest() {
        println("Normal: " + lowestPositiveInteger(intArrayOf(3, 4, -1, 1, 1, 1, 1)))
        println("Sorting: " +lowestPositiveIntegerSort(intArrayOf(3, 4, -1, 1, 1, 1, 1)))

        println("Normal: " +lowestPositiveInteger(intArrayOf(0, 1, 2)))
        println("Sorting: " +lowestPositiveIntegerSort(intArrayOf(0, 1, 2)))

        println("Normal: " +lowestPositiveInteger(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)))
        println("Sorting: " +lowestPositiveIntegerSort(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)))

        println("Normal: " +lowestPositiveInteger(intArrayOf(-1, -2, -3, -4, 0)))
        println("Sorting: " +lowestPositiveIntegerSort(intArrayOf(-1, -2, -3, -4, 0)))
    }

    private fun lowestPositiveIntegerSort(arr: IntArray): Int {
        for (i in arr.indices) {
            if (arr[i] >= arr.size || arr[i] < 0) {
                arr[i] = 0
            }
        }
        arr.sort()

        for (i in 1 until arr.size) {
            if (arr[i] - arr[i - 1] > 1) {
                return arr[i - 1] + 1
            }
        }
        return arr.last() + 1
    }

    private fun lowestPositiveInteger(arr: IntArray): Int {
        var lowestPositive = 1
        for (i in arr.indices) {
            if (arr[i] >= arr.size || arr[i] < 0) {
                arr[i] = Int.MAX_VALUE
            }
        }

        for (i in arr) {
            if (i < arr.size) {
                if (i > 0) {
                    if (arr[i] > 0) {
                        arr[i] = -arr[i]
                    }

                } else {
                    if (arr[-i] > 0) {
                        arr[-i] = -arr[-i]
                    }
                }
            }
        }

        for (i in 1 until arr.size) {
            if (arr[i] < 0) {
                lowestPositive++
            } else {
                break
            }
        }
        return lowestPositive;
    }

}