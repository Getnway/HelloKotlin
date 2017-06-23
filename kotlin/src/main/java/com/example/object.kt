package com.example

/**
 * Author: getnway on 17-06-20.
 * Email: getnway@gmail.com
 */
// 1.类似与Java的匿名内部类，但访问函数局部变量不需要final
class View {
    var listener: OnClickListener? = null

    interface OnClickListener {
        fun onClick()
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        listener = onClickListener
    }

    fun execute() {
        listener?.onClick()
    }
}

fun anonymousClass() {
    var a = 5   // 访问函数局部变量不需要final
    var view = View()
    view.setOnClickListener(object : View.OnClickListener {
        override fun onClick() {
            println("onClick(): $a")
            a += 5
        }
    })
    view.execute()
    println("anonymousClass(): $a")
}

// 2.just an object
fun justObject() {
    val adHoc = object {
        var x: Int = 1
        var y: Int = 2
    }
    println("justObject(): ${adHoc.x} + ${adHoc.y} = ${adHoc.x + adHoc.y}")
}

// 3.如果object是public函数的返回值，或是public属性，则该属性或函数返回值为object的超类
class ObjectClass {
    // 私有函数，返回匿名object类型
    private fun privateF() = object {
        val x: String = "x"
    }

    // 公有函数，返回Any
    fun publicF() = object {
        val x: String = "x"
    }

    fun objectReturn() {
        val x1 = privateF().x // Works
//        val x2 = publicF().x  // ERROR: Unresolved reference 'x'
    }
}

class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

val instance = MyClass.create()

// 或省略object名
class MyClass2 {
    companion object {
        fun create(): MyClass2 = MyClass2()
    }
}

val instance2 = MyClass2.Companion.create()