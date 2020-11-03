package com.dailycode.others

import com.dailycode.Test
import com.dailycode.helper.BinarySearchTree

class BST : Test {

    override fun runTest() {
        val bst = BinarySearchTree(1)
        bst.insert(2)
        bst.node = bst.balanceTreeNew(bst.node)!!
        println()
        bst.printPreOrder(bst.node)
        bst.insert(3)
        bst.node = bst.balanceTreeNew(bst.node)!!
        println()
        bst.printPreOrder(bst.node)
        bst.insert(4)
        bst.node = bst.balanceTreeNew(bst.node)!!
        println()
        bst.printPreOrder(bst.node)
        bst.insert(5)
        bst.node = bst.balanceTreeNew(bst.node)!!
        println()
        bst.printPreOrder(bst.node)
        bst.insert(6)
        bst.node = bst.balanceTreeNew(bst.node)!!
        println()
        bst.printPreOrder(bst.node)
        bst.insert(7)
        bst.node = bst.balanceTreeNew(bst.node)!!
        /*bst.insert(8)
        bst.node = bst.balanceTreeNew(bst.node)!!*/

       /* println()
        bst.printInOrder(bst.node)*/
        println()
        bst.printPreOrder(bst.node)
    }

}