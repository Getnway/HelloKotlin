package com.example

fun main(args: Array<String>) {
    println("Kotlin")
    var k = KotlinClass()

    k.useBoolean(null)
    k.useBoolean(true)
    k.useBoolean(false)
    println()

    k.autoCast(1)
    k.autoCast("123")
    println()

    k.loop()
    println()

    k.ifStatement(2)
    println()

    println("whenStatement(1) ${k.whenStatement(1)}")
    println("whenStatement(100L) ${k.whenStatement(100L)}")
    println("whenStatement(100F) ${k.whenStatement(100F)}")
    println()

    k.rangs(10)
    println()

    println("nullCheck(null) ${k.nullCheck(null)}")
    println("nullCheck(abc) ${k.nullCheck("abc")}")
    println()

    k.tryCatch()
    println()

    k.list()
    println()
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

// constructor关键字声明构造函数，参数可以定义默认值
class Person public constructor(firstName: String = "") {
    // init关键字声明初始化代码块
    init {
        // firstName可以在这里使用
        println("init")
    }

    // 如果类有主构造函数，其他构造函数需要直接或间接的调用主构造函数
    constructor(firstName: String, parent: Person) : this(firstName) {
        println("constructor(firstName: String, parent: Person) : this(firstName)")
    }
}
