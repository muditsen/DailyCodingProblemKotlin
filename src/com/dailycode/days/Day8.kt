package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.TreeNode

/***
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 */
class Day8 : Test {

    override fun runTest() {
        val treeNode = TreeNode(0)
        treeNode.left = TreeNode(1)
        treeNode.right = TreeNode(0)
        treeNode.right?.left = TreeNode(1)
        treeNode.right?.right = TreeNode(0)
        treeNode.right?.left?.left = TreeNode(1)
        treeNode.right?.left?.right = TreeNode(1)

        println(getUnivalTrees(treeNode))
    }

    private fun getUnivalTrees(node: TreeNode?): Int {
        if (node?.left == null && node?.right == null) {
            return 1
        }
        if (node.item == node.left?.item && node.item == node.right?.item) {
            return 1 + getUnivalTrees(node.left) + getUnivalTrees(node.right)
        }
        return getUnivalTrees(node.left) + getUnivalTrees(node.right)
    }

}