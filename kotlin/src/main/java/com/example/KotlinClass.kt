package com.example

import com.example.`class`.C
import com.example.`class`.DD
import com.example.`class`.Person
import com.example.`class`.User
import java.util.Arrays.asList

const val MAX = 239

object Obj {
    @JvmStatic fun foo() {}
    fun bar() {}
}

fun main(args: Array<String>) {
    println("Kotlin")
//    baseStatement()
//    classStatement()
//    objectStatement()

    lambdaStatement()
}

private fun lambdaStatement() {
    fun <T, R> lambdaMap(ints: List<T>, transform: (T) -> R): List<R> {
        val result = arrayListOf<R>()
        for (item in ints)
            result.add(transform(item))
        return result
    }

    val ints = asList(1, 2, 3, 5, 7, 9, 4, 6, 8)
    var doubled = lambdaMap(ints, { value -> value * 2 })
    println("lambdaStatement() $doubled")

    // it：单个参数的隐式名称
    doubled = lambdaMap(ints) { it * 2 }
    println("lambdaStatement() $doubled")

    doubled = ints.filter { it > 5 }.sortedBy { it }.map { it * 2 }
    println("lambdaStatement() $doubled")
}

fun objectStatement() {
    anonymousClass()
    justObject()
    ObjectClass().objectReturn()
}

private fun classStatement() {
    // constructor
    println("========= constructor =========")
    var unset = Person()
    var mike = Person("mike")
    var john = Person("john", "wall")

    // inherit
    println("========= inherit =========")
    val c = C()
    c.f()
    c.a()
    c.b()

    // interface
    println("========= interface =========")
    DD().method()

    // data class
    println("========= data class =========")
    var user = User("kk", 15)
    println("user: ${user.toString()}")
}

private fun baseStatement() {
    var k = KotlinClass()

    println("========= useBoolean =========")
    k.useBoolean(null)
    k.useBoolean(true)
    k.useBoolean(false)
    println()

    println("========= autoCast =========")
    k.autoCast(1)
    k.autoCast("123")
    println()

    println("========= loop =========")
    k.loop()
    println()

    println("========= ifStatement =========")
    k.ifStatement(2)
    println()

    println("========= whenStatement =========")
    println("whenStatement(1) ${k.whenStatement(1)}")
    println("whenStatement(100L) ${k.whenStatement(100L)}")
    println("whenStatement(100F) ${k.whenStatement(100F)}")
    println()

    println("========= rangs =========")
    k.rangs(10)
    println()

    println("========= nullCheck =========")
    println("nullCheck(null) ${k.nullCheck(null)}")
    println("nullCheck(abc) ${k.nullCheck("abc")}")
    println()

    println("========= tryCatch =========")
    k.tryCatch()
    println()

    println("========= list =========")
    k.list()
    println()

    println("========= extend function =========")
    extendFunction()
}

class KotlinClass {
    fun useBoolean(b: Boolean?) {
        if (b == true) {
            println("useBoolean() `b` is true: $b")
        } else {
            // `b` is false or null
            println("useBoolean() `b` is false or null: $b")
        }
    }

    fun autoCast(obj: Any): Int? {
        if (obj is String) {
            println("autoCast($obj) return ${obj.length}")
            return obj.length    // `obj`自动转为`String`
        }
        println("autoCast($obj) return null")
        return null
    }

    fun loop() {
        print("loop()")
        val items = listOf("apple", "banana", "kiwi")
        for (item in items) {    // 迭代器
            print(item + " ")
        }
        println()
        for (index in items.indices) {
            println("loop() item at $index is ${items[index]}")
        }
        for ((index, value) in items.withIndex()) {
            println("loop() the element at $index is $value")
        }

        var index = 0
        while (index < items.size) {
            println("loop() item at $index is ${items[index]}")
            index++
        }
    }

    fun ifStatement(param: Int) {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
        println("ifStatement($param) result: $result")
    }

    fun whenStatement(obj: Any): String =
            when (obj) {
                0, 1 -> "Zero or One"
                "Hello" -> "World"
                is Long -> "Long"
                !is String -> "Not a string"
                else -> "Unknown"
            }

    fun rangs(a: Int) {
        if (a in 1..10) {
            println("rangs() a in 1..10: $a")    // a是否在[0,10]之内
        }

        print("rangs() x in 1..5:")
        for (x in 1..5) {
            print(x)    // 输出：12345
        }
        println()

        print("rangs() x in 1 until 5:")
        for (x in 1 until 5) {
            print(x)    // 输出：1234
        }
        println()

        print("rangs() x in 1..10 step 2:")
        for (x in 1..10 step 2) {
            print(x)    // 输出：13579
        }
        println()

        print("rangs() x in 9 downTo 0 step 3:")
        for (x in 9 downTo 0 step 3) {
            print(x)    // 输出：9630
        }
        println()
    }

    fun nullCheck(str: String?): Int {
        str?.let {
            println("nullCheck($str) str not null") // str不为null时才执行
        }
        return str?.length ?: -1    // str为null时，返回-1，否则返回str长度
    }

    fun tryCatch() {
        val result = try {
            nullCheck("abcdefg")
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }
        println("tryCatch() result:$result")
    }

    fun list() {
        fun <T> asList(vararg ts: T): List<T> {
            val result = ArrayList<T>()
            for (t in ts) // ts is an Array
                result.add(t)
            return result
        }

        val list = asList(1, 2, 3)
        println("list() list: $list")

        // or
        val a = arrayOf(1, 2, 3)
        val list2 = asList(-1, 0, *a, 4)
        println("list() list2:$list2")
    }
}
