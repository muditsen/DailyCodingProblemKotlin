package com.dailycode

/***
 * Implement integer exponentiation. That is,
 * implement the pow(x, y) function, where x and y are integers and returns x^y.
 ***/


class DailyCodingProblem447 : Test{

    override fun runTest(){
        var startTime = System.nanoTime()
        println(naive(8979.0, 50))
        println("Time taken: " + (System.nanoTime() - startTime))

        startTime = System.nanoTime()
        println(optimal(8979.0, 50))
        println("Time taken: " + (System.nanoTime() - startTime))
    }

    private fun naive(x: Double, y: Int): Double {
        if (y == 1) {
            return x
        }
        return x * naive(x, y - 1)
    }

    private fun optimal(x: Double, y: Int): Double {
        if (y < 2) {
            return x;
        }
        return if (y % 2 == 0) {
            optimal(x, y / 2) * optimal(x, y / 2)
        } else {
            optimal(x, y / 2) * optimal(x, y / 2) * x
        }
    }
}