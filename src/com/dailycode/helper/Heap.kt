package com.dailycode.helper

interface Heap<T> {

    fun insert(value: T)

    fun top(): Int

    fun left(pos: Int): Int

    fun right(pos: Int): Int

    fun remove(): Int

    fun heapfy();

}