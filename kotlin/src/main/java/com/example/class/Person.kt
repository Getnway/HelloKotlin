package com.example.`class`

/**
 * Author: getnway on 17-06-20.
 * Email: getnway@gmail.com
 */
// constructor关键字声明构造函数，参数可以定义默认值
class Person public constructor(name: String = "default") {
    // init关键字声明初始化代码块
    init {
        // name可以在这里使用
        println("init $name")
    }

    // 如果类有主构造函数，其他构造函数需要直接或间接的调用主构造函数
    constructor(name: String, nick: String) : this(name) {
        println("constructor($name, $nick) : this($name)")
    }
}