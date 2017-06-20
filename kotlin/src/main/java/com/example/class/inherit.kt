package com.example.`class`

/**
 * Author: getnway on 17-06-20.
 * Email: getnway@gmail.com
 */
// open与Java的final相反，Kotlin默认类是不能被继承的
open class Base {
    open fun v() {}
    fun nv() {}
}
class Derived() : Base() {
    // 如果不想被子类重写，可使用final：final override fun v() {}
    override fun v() {}
    // 子类定义与父类拥有相同签名的函数是不允许的
//    override fun nv() {}
}



open class A {
    open fun f() { println("A") }
    fun a() { println("a") }
}

interface B {
    fun f() { println("B") } // interface成员默认是open的
    fun b() { println("b") }
}

class C() : A(), B {
    // 当多个父类中有相同签名的函数，则子类必须重
    override fun f() {
        super<A>.f() // call to A.f()
        super<B>.f() // call to B.f()
    }
}