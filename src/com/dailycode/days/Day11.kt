package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.Trie

/***
Implement an autocomplete system.
That is, given a query string s and a set of all possible query strings,
return all strings in the set that have s as a prefix.
For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 */
class Day11 : Test {

    override fun runTest() {
        val trie = Trie()
        trie.insert("dog")
        trie.insert("doggo")
        trie.insert("deer")
        trie.insert("deep")
        trie.insert("deal")
        trie.insert("peal")
        trie.insert("pin")
        trie.insert("post")
        trie.insert("poster")
        trie.insert("dad")
        trie.insert("daily")
        trie.insert("daily")
        trie.insert("dam")
        trie.insert("damage")
        trie.insert("damp")
        trie.insert("dance")
        trie.insert("danger")
        trie.insert("dangerous")
        trie.insert("dare")
        trie.insert("dare")
        trie.insert("dark")
        trie.insert("data")
        trie.insert("date")
        trie.insert("daughter")
        trie.insert("dawn")
        trie.insert("day")
        trie.insert("dead")
        trie.insert("deaf")
        trie.insert("deal")
        trie.insert("deal")
        trie.insert("deal")
        trie.insert("dear")
        trie.insert(" death")

        trie.search("d")
        println()
        trie.search("pos")

    }

}