/*
* Object declaration and companion objects.
*
* Here the concept of the singleton is involved.
* What is Singleton ?
* -> we have only "one instance" of the class in the whole application.
*
* By declaring object, Kotlin internally creates the class and an instance/object.
* It can also have the init block.
* It can have properties, methods, initializers
* It cannot have constructors (it may be primary or may be secondary).
* It supports inheritance.
*
* We cannot create the instance of the class, we have to access the methods and properties with class name itself.
* */

fun main() {

    // Object declaration
    println(Base1.count)
    Base1.display()

    println(Derived.count)
    Derived.display()

    // Companion object
    println(Base3.id)
    Base3.companionObjectFunction()
}

object Base1 {
    var count = 1 // Behaves like a static variable
    fun display() { // Behaves like a static method
        println("Hello World")
    }
}

open class Base2 {
    open var count = 2
    open fun display() {
        println("Hello World")
    }
}

// Using object declaration we can also inherit another class too.
object Derived : Base2() {
    override var count: Int = 10
    override fun display() {
        println(count)
    }

    init {
        println("Derived object initializer")
    }
}

/* --------------------------------------------------------------------
* Companion objects
*
* These are same like the objects but these are declared inside the class.
*
* By using companion objects the methods and variables inside the class can be accessed
* without instantiating the class
*
* the JVMstatic annotation makes the interoperable with the java files
* */
class Base3 {
    companion object MyCompanionObject {
        var id: Int = 20 // Behaves like a static variable

        @JvmStatic // This annotation makes the following function static in the JVM compiler.
        fun companionObjectFunction() { // Behaves like a static function
            println("Companion object class function")
        }
    }
}