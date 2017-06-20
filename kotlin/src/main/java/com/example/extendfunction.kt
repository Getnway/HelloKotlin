package com.example

/**
 * Author: getnway on 17-06-20.
 * Email: getnway@gmail.com
 */
// 1. 扩展函数的调用，只跟调用该扩展函数的类型有关
open class BaseClass

class DerivedClass : BaseClass()

fun BaseClass.foo() = "BaseClass"
fun DerivedClass.foo() = "DerivedClass"

fun printFoo(baseClass: BaseClass) {
    println(baseClass.foo())    // BaseClass.foo()会被调用
}
//printFoo(DerivedClass()) // 输出BaseClass


// 2. 成员函数和扩展函数具有相同函数签名时，会调用成员函数
class F {
    fun foo() {
        println("member")
    }
}

fun F.foo() {
    println("extension")
}

//F().foo() // 输出"member"

fun extendFunction() {
    printFoo(DerivedClass()) // 输出BaseClass
    F().foo() // 输出"member"
}