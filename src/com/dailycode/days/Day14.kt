package com.dailycode.days

import com.dailycode.Test
import kotlin.random.Random

/***
 * The area of a circle is defined as πr^2. Estimate π to 3 decimal places using a Monte Carlo method.
 */

class Day14 : Test {
    override fun runTest() {
        println("1: " + solution(1))
        println("2: " + solution(5))
        println("3: " + solution(10))
        println("4: " + solution(100))
        println("5: " + solution(1000))
        println("6: " + solution(10000))
        println("7: " + solution(100000))
        println("8: " + solution(100000))
        println("9: " + solution(1000000))
        println("10: " + solution(10000000))
        println("11: " + solution(100000000))
        println("12: " + solution(1000000000))
        println("13: " + solution(10000000000))
    }


    private fun solution(numberOfIterations: Long): Double {

        var xt = 0.0
        var yt = 0.0
        val x = 0.5 //center
        val y = 0.5
        var count = 0

        for (i in 0 until numberOfIterations) {
            xt = Random.nextDouble()
            yt = Random.nextDouble()

            if (0.5 >= Math.sqrt(Math.pow(xt - x, 2.0) + Math.pow(yt - y, 2.0))) {
                count++
            }


            //println(count.toDouble() / (i+1).toDouble() * 4)
        }

        return count.toDouble() / numberOfIterations.toDouble() * 4
    }


}