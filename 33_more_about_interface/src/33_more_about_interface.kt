/*
* what if the interface and the class contain the same function which is implemented inside the derived class
*
* In that case we need to use the super<PerticularClassName_or_PerticularInterfaceName>.methodName
* */

fun main() {
    val o = Derived()
    o.read()
}

interface MyFirstInterface {
    fun read() {
        println("Hello")
    }
}

interface MySecondInterface {
    fun read() {
        println("World")
    }
}

open class Base {
    open fun read() {
        println("and Aditya")
    }
}

class Derived : MyFirstInterface, MySecondInterface, Base() {
    override fun read() {
        super<MyFirstInterface>.read()
        super<MySecondInterface>.read()
        super<Base>.read()
    }
}