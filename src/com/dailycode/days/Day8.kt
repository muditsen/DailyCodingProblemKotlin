package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.TreeNode

/***
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 */
class Day8 : Test {
    private var count = 0
    override fun runTest() {
        val treeNode = TreeNode(0)
        treeNode.left = TreeNode(1)
        treeNode.right = TreeNode(0)
        treeNode.right?.left = TreeNode(1)
        treeNode.right?.right = TreeNode(0)
        treeNode.right?.left?.left = TreeNode(1)
        treeNode.right?.left?.right = TreeNode(1)

        getUnivalTrees(treeNode)
        println(count)
    }

    private fun getUnivalTrees(node: TreeNode?): Boolean {
        if (node?.left == null && node?.right == null) {
            count++
            return true
        }

        val left = getUnivalTrees(node.left)
        val right = getUnivalTrees(node.right)

        val bool = left && right && ((node.left?.item ?: node.item) == node.item) && ((node.right?.item ?: node.item) == node.item)
        if (bool) {
            count++
        }
        return bool
    }

}