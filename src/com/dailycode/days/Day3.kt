package com.dailycode.days

import com.dailycode.Test
import com.dailycode.helper.TreeNode

/***
 * Given the root to a binary tree, implement serialize(root),
 * which serializes the tree into a string, and deserialize(s),
 * which deserializes the string back into the tree.
 */
class Day3 :Test {

    override fun runTest() {
        val root = TreeNode(1)
        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left?.left = TreeNode(4)
        root.left?.right = TreeNode(5)
       // root.left?.left = TreeNode(4)
        root.right?.right = TreeNode(6)

        val treeString = serialize(root)

        println(treeString)

        val rootDes = deserialize(treeString)
        println(checkEquality(root,rootDes))
    }

    private fun serialize(root: TreeNode?):String{
        if(root == null){
            return "#"
        }
        return ""+root.item + serialize(root.left) + serialize(root.right);
    }

    private var currPos:Int = 0

    private fun deserialize(inputString:String,):TreeNode?{
        if(inputString[currPos] == '#'){
            return null
        }
        val root = TreeNode("${inputString[currPos]}".toInt())

        currPos++
        root.left = deserialize(inputString)

        currPos++
        root.right = deserialize(inputString)
        return root
    }

    private fun checkEquality(root: TreeNode?,root2: TreeNode?):Boolean{
        if(root == null && root2 == null){
            return true
        }

        if(root?.item == root2?.item){
            return checkEquality(root?.left,root2?.left) && checkEquality(root?.right,root2?.right)
        }

        return false
    }

}