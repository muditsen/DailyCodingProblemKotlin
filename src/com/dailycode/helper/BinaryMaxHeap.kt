package com.dailycode.helper

import java.lang.IndexOutOfBoundsException

class BinaryMaxHeap() : Heap<Int> {

    var list = ArrayList<Int>()
        private set

    override fun insert(value: Int) {
        list.add(value)
        var n = list.size - 1
        while (n < list.size) {
            val parent = ((n - 1) / 2).toInt()
            if (list[parent] < list[n]) {
                val tmp = list[parent]
                list[parent] = list[n]
                list[n] = tmp
                n = parent
            } else {
                break
            }
        }
    }

    override fun top(): Int {
        return list.first()
    }

    override fun left(pos: Int): Int {
        return list[pos * 2 + 1]
    }

    override fun right(pos: Int): Int {
        return list[pos * 2 + 2]
    }

    override fun remove(): Int {
        val top = top()
        list[0] = list[list.size - 1]
        list.removeLast()
        var n = 0
        var l: Int
        var r: Int

        //Helper.printArr(list)

        while (n < list.size - 1) {
            l = n * 2 + 1
            r = n * 2 + 2
            if (getElement(l) > getElement(n) && getElement(l) > getElement(r)) {
                val tmp = list[l]
                list[l] = list[n]
                list[n] = tmp
                n = l
            } else if (getElement(r) > getElement(n) && getElement(r) > getElement(l)) {
                val tmp = list[r]
                list[r] = list[n]
                list[n] = tmp
                n = r
            } else {
                break
            }
        }

        return top
    }

    private fun getElement(pos: Int): Int {
        return try {
            list[pos]
        } catch (e: IndexOutOfBoundsException) {
            Int.MIN_VALUE
        }
    }

    override fun heapfy() {

    }


}