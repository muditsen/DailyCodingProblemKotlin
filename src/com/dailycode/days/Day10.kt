package com.dailycode.days

import com.dailycode.Test

/***
 * Implement a job scheduler which takes in a function f and an integer n,
 * and calls f after n milliseconds.
 */
typealias Method = () -> Unit

class Day10 : Test {

    private fun schedule(method: Method, millisecond: Long) {

        val timeToReach = System.currentTimeMillis() + millisecond;
        Thread {
            while (System.currentTimeMillis() <= timeToReach) {
                println("Time remaining.." + (timeToReach - System.currentTimeMillis()))
                Thread.sleep(millisecond / 10)
            }
            method()
        }.start()
    }

    override fun runTest() {
        schedule(method = Day10()::testMethod, 10000)
        schedule(method = Day10()::testMethod, 500)
    }

    private fun testMethod() {
        println("Executing test...")
    }

}

