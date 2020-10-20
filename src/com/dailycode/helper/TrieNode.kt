package com.dailycode.helper

class TrieNode {
    val map = LinkedHashMap<Char, TrieNode>()
    var isEndOfTheWord = false
}