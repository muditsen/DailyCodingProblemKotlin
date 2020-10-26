package com.dailycode.helper

class Helper {
    companion object {
        fun printArr(intArray: IntArray) {
            for (i in intArray) {
                print("$i ")
            }
            println()
        }

        fun printArr(intArray: ArrayList<Int>) {
            for (i in intArray) {
                print("$i ")
            }
            println()
        }
    }
}