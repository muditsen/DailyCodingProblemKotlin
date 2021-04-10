package com.dailycode.leetcode.binarytree

import com.dailycode.Test
import com.dailycode.days.Day3
import com.dailycode.helper.BinarySearchTree
import com.dailycode.helper.TreeNode

class BinaryTreeFromPreorderAndInorder : Test {

    override fun runTest() {
        val root = buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
        val binarySearchTree = BinarySearchTree(1)
        binarySearchTree.printPreOrder(root)
        println()
        binarySearchTree.printInOrder(root)
        println()


    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return buildTreeHelper(preorder, inorder, 0, inorder.size - 1)
    }

    var preIndex = 0

    fun buildTreeHelper(preorder: IntArray, inorder: IntArray, inStart: Int, inOrderEnd: Int): TreeNode? {
        if (inStart > inOrderEnd || preIndex >= preorder.size) {
            return null
        }
        val node = TreeNode(preorder[preIndex])

        var i = inStart
        while (i <= inOrderEnd) {
            if (inorder[i] == preorder[preIndex]) {
                break
            }
            i++
        }
        preIndex++

        node.left = buildTreeHelper(preorder, inorder, inStart, i - 1)
        node.right = buildTreeHelper(preorder, inorder, i + 1, inOrderEnd)
        return node;
    }


}