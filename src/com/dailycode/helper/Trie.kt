package com.dailycode.helper

class Trie {

    val rootNode: TrieNode = TrieNode()

    fun insert(word: String) {
        var  i = 0
        var node = rootNode
        for (char in word) {
            if (node.map.containsKey(char) && node.map[char] != null) {
                node = node.map[char]!!
            } else {
                node.map[char] = TrieNode()
                node = node.map[char]!!
                if (i == word.length-1) {
                    node.isEndOfTheWord = true
                }
            }
            i++
        }
    }

    private var endOfTheWord = false


    fun printTrie(node: TrieNode?, word: String,list:ArrayList<String>) {
        if (node == null) {
            return
        }

        if (node.isEndOfTheWord) {
            //println()
            endOfTheWord = true
            list.add(word)
        }

        for (entry in node.map) {
            if (endOfTheWord) {
                endOfTheWord = false

                //print(word)
            }
           // print(entry.key)

            printTrie(entry.value, word + entry.key,list)
        }
    }

    fun search(query: String) {
        var node: TrieNode? = rootNode
        for (char in query) {
            node = if (node?.map?.containsKey(char) == true && node.map[char] != null) {
                node.map[char]!!
            } else {
                null
            }
        }
        endOfTheWord = true
        val list=  ArrayList<String>();
        printTrie(node, query,list)
        for(i in list){
            print("$i ")
        }
    }

}