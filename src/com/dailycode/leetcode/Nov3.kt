package com.dailycode.leetcode

import com.dailycode.Test

class Nov3 :Test{
    override fun runTest() {
        println(maxPower("a"))
        println(maxPower("cc"))
        println(maxPower("leetcode"))
        println(maxPower("abbcccddddeeeeedcba"))
        println(maxPower("triplepillooooow"))
        println(maxPower("hooraaaaaaaaaaay"))
        println(maxPower("tourist"))
    }

    fun maxPower(s: String): Int {
        var max = 1
        var count = 1
        for(i in 1..s.length-1){
            if(s[i] == s[i-1]){
                count++
            }else{
                max = if (count > max) count else max
                count = 1
            }
        }
        max = if (count > max) count else max
        return max
    }

}