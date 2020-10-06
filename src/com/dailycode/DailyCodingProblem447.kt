package com.dailycode

/***
 * Implement integer exponentiation. That is,
 * implement the pow(x, y) function, where x and y are integers and returns x^y.
 ***/

fun main(args: Array<String>) {
    val problem = DailyCodingProblem447()
    var startTime = System.nanoTime()
    println(problem.naive(8979.0, 5))
    println("Time taken: " + (System.nanoTime() - startTime))

    startTime = System.nanoTime()
    println(problem.optimal(8979.0, 5))
    println("Time taken: " + (System.nanoTime() - startTime))
}

class DailyCodingProblem447 {

    fun naive(x: Double, y: Int): Double {
        if (y == 1) {
            return x
        }
        return x * naive(x, y - 1)
    }

    fun optimal(x: Double, y: Int): Double {
        if (y < 2) {
            return x;
        }
        if (y % 2 == 0) {
            return optimal(x, y / 2) * optimal(x, y / 2)
        } else {
            return optimal(x, y / 2) * optimal(x, y / 2) * x
        }
    }
}