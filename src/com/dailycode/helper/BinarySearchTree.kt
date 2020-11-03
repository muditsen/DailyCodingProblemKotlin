package com.dailycode.helper

import com.sun.source.tree.Tree

class BinarySearchTree(private val rootVal: Int) {

    var node: TreeNode = TreeNode(rootVal)

    // 5 2 6 8 3 7 9 4
    fun insert(value: Int) {
        //println("Inserting: $value")
        var p: TreeNode? = node
        while (true) {
            if (p == null) {
                break
            }
          //  print("${p.item} ")
            if (value <= p.item) {
               // print(" Going Left ")
                if (p.left == null) {
                    p.left = TreeNode(value)
                    break
                } else {
                    p = p.left
                }
            } else {
             //   print(" Going right ")
                if (p.right == null) {
                    p.right = TreeNode(value)
                    break
                } else {
                    p = p.right
                }
            }
        }
    }

    //AVL
    fun balanceTreeNew(node: TreeNode?): TreeNode? {
        if (node == null) {
            return null
        }

        var tempNode: TreeNode? = node
        while (true) {
            val leftHeight = getHeight(tempNode?.left)
            val rightHeight = getHeight(tempNode?.right)

            if (leftHeight - rightHeight >= 2) {
                if (getHeight(tempNode?.left?.right) - getHeight(tempNode?.left?.left) >= 1) {
                    tempNode?.left = rotateLeft(tempNode?.left)
                }
                tempNode = rotateRight(tempNode)
            } else if (rightHeight - leftHeight >= 2) {
                if (getHeight(tempNode?.right?.left) - getHeight(tempNode?.right?.right) >= 1) {
                    tempNode?.right = rotateRight(tempNode?.right)
                }
                tempNode = rotateLeft(tempNode)
            } else {
                break
            }
        }

        tempNode?.left = balanceTreeNew(tempNode?.left)
        tempNode?.right = balanceTreeNew(tempNode?.right)

        return tempNode;


    }

    fun getHeight(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        return 1 + getHeight(node.left).coerceAtLeast(getHeight(node.right))
    }

    fun rotateLeft(node: TreeNode?): TreeNode? {
        val p = node
        val r = p?.right ?: return node
        val rl = r.left
        r.left = p
        p.right = rl
        return r
    }

    fun rotateRight(node: TreeNode?): TreeNode? {
        val p = node
        val l = p?.left ?: return node
        val lr = l.right
        l.right = p
        p.left = lr
        return l
    }


    //left root right
    fun printInOrder(node: TreeNode?) {
        if (node == null) {
            return
        }
        printInOrder(node.left)
        print("${node.item} ")
        printInOrder(node.right)
    }

    //root left right
    fun printPreOrder(node: TreeNode?) {
        if (node == null) {
            return
        }
        print("${node.item} ")
        printPreOrder(node.left)
        printPreOrder(node.right)
    }

    //left right root
    fun printPostOrder(node: TreeNode?) {
        if (node == null) {
            return
        }
        printPostOrder(node.left)
        printPostOrder(node.right)
        print("${node.item} ")
    }

}