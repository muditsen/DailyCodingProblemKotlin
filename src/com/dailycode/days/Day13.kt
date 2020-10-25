package com.dailycode.days

import com.dailycode.Test

/****
 * Given an integer k and a string s,
 * find the length of the longest substring that contains at most k distinct characters.
 ****/

class Day13 : Test {
    override fun runTest() {
        println(solution("abcba", 2))
        println(solution("aaaaa", 1))
        println(solution("abcdef", 2))
        println(solution("abcdefghijkalmnop", 10))
        println(solution("abcdefgabcedefg", 2))
        println(solution("abcdefgabcedefg", 7))
        println(solution("abcdefgabcedefg", 1))
        println(solution("abcdefgabcedefg", 4))
        println(solution("abcba", 3))
        println(solution("abcba", 1))
        println(solution("aabbcc", 1))
        println(solution("aabbcc", 2))
        println(solution("aabbcc", 3))
        println(solution("aaabb", 3))
    }

    private fun solution(str: String, k: Int): Int {
        var i = 0
        var j = 0
        var count = 0
        var maxCount = 0
        var value: Int
        val set = HashSet<Char>()
        while (i < str.length) {
            maxCount = if (count > maxCount) count else maxCount
            count = 0
            value = k
            set.clear()
            j = i
            while (set.size < k + 1 && j < str.length) {
                if (!set.contains(str[j])) {
                    set.add(str[j])
                    value--
                }
                if (value > -1) {
                    count++
                    j++
                }

            }
            if (j == str.length) {
                break
            } else if (j - 1 != i) {
                i = j - 1
            } else {
                i++
            }

        }
        maxCount = if (count > maxCount) count else maxCount
        return maxCount
    }

}