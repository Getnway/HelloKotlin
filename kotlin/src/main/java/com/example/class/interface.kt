package com.example.`class`

/**
 * Author: getnway on 17-06-20.
 * Email: getnway@gmail.com
 */
interface AA {
    fun method() { println("AA") }
    fun otherMethod()
}

interface BB {
    fun method() { println("BB") }
    fun otherMethod() { println("otherMethod") }
}

class CC : AA {
    override fun otherMethod() { println("otherMethod") }
}

class DD : AA, BB {
    override fun method() {
        super<AA>.method()
        super<BB>.method()
    }

    override fun otherMethod() {
        super<BB>.otherMethod()
    }
}