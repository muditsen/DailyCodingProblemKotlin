package com.dailycode

import com.dailycode.leetcode.array.RotatedArray

fun main(args: Array<String>) {
    val test: Test = RotatedArray()
    println(":::::::::Running test cases of ${test.getName()}:::::::::")
    test.runTest()
    try{

        ClassLoader.getSystemClassLoader().loadClass("com.dailycode.days.Day18")
        println("Class loaded.")
    }catch (e:Exception){
        println("Class not found")
    }

}

fun printLog(vararg items: Any) {
    for (t in items) {
        print("$t ")
    }
    println()
}