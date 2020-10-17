package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.Helper

/***
 *
 * Given the mapping a = 1, b = 2, ... z = 26, and an encoded message,
 * count the number of ways it can be decoded.
 */

class Day7 : Test {

    override fun runTest() {
        println(decode("123412341234", 0))
        val array = IntArray("123412341234".length + 1) {
            -1
        }
        println(decodeDp1("123412341234", 0, array))
        Helper.printArr(array)
        println(decodeDp2("123412341234"))
    }

    private fun decode(input: String, pos: Int): Int {
        if (pos >= input.length - 1) {
            return 1
        }
        if (input[pos] == '1' || input[pos] == '2') {
            return decode(input, pos + 1) + decode(input, pos + 2)
        }
        return decode(input, pos + 1)
    }

    private fun decodeDp1(input: String, pos: Int, array: IntArray): Int {
        if (pos >= input.length - 1) {
            return 1
        }

        if (array[pos] != -1) {
            return array[pos]
        }

        if (input[pos] == '1' || input[pos] == '2') {
            array[pos] = decodeDp1(input, pos + 1,array) + decodeDp1(input, pos + 2,array)
            return array[pos];
        }
        array[pos] = decodeDp1(input, pos + 1,array)
        return array[pos]
    }

    private fun decodeDp2(input: String): Int {
        var n1 = 1
        var n2 = 1
        var n3 = 1
        for (i in 1 until input.length) {
            if (input[i-1] == '1' || input[i-1] == '2') {
                n3 = n1 + n2
                n1 = n2
                n2 = n3
            }else{
                n1 = n2
            }
        }
        return n3
    }

}