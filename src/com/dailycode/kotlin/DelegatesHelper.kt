package com.dailycode.kotlin

import kotlin.reflect.KProperty

class DelegatesHelper {

    var operator: Operator = Add()

    enum class Operation {
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    interface Operator {
        fun operation(v1: Int, v2: Int): Int
    }

    public class Add : Operator {
        override fun operation(v1: Int, v2: Int): Int {
            return v1 + v2
        }

    }

    public class Subtract : Operator {
        override fun operation(v1: Int, v2: Int): Int {
            return v1 + v2
        }

    }

    public class Multiply : Operator {
        override fun operation(v1: Int, v2: Int): Int {
            return v1 + v2
        }

    }

    public class Divide : Operator {
        override fun operation(v1: Int, v2: Int): Int {
            return v1 + v2
        }

    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Operator {
        return operator
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Operation) {
        operator = when (value) {
            Operation.ADD -> {
                Add()
            }
            Operation.SUBTRACT -> {
                Subtract()
            }
            Operation.MULTIPLY -> {
                Multiply()
            }
            Operation.DIVIDE -> {
                Divide()
            }
        }
    }




}