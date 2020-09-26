/*
* In Kotlin by default the classes are "final" and "public"
* so if the classes are final and public, then the properties and methods of that particular class are also final by default
*
* So to override the methods and the properties of the class we need to invoke the "open" keyword while declaring them.
*
* While overriding the properties and methods of parent class in chile class we need to invoke the "override" keyword before invoking them.
*
* */

fun main() {
    val dogO = Dog()
    val catO = Cat()

    println("Dog\nBreed : ${dogO.breed} Color : ${dogO.color}")
    dogO.eat()

    println("Cat\nBreed : ${catO.breed} Color : ${catO.color}")
    catO.eat()
}

open class Animal {
    open var breed: String = ""
    open var color: String = ""

    open fun eat() {
        println("Animal is eating")
    }

    init {
        println("Hello")
    }
}

class Dog : Animal() {
    override var breed: String = "PUG"
    override var color: String = "Brown"

    override fun eat() {

        // if the class is implementing a interface then, if that interface contains the same eat() method
        // we need to invoke the following syntax to call the eat() method, from parent class
        super<Animal>.eat()
        // if we want to call the same eat() method form the interface then in the angular brackets Interface name should be invoked

        println("Dog is Eating")
    }
}

class Cat : Animal() {
    override var breed: String = "American"
    override var color: String = "Black"

    override fun eat() {
        println("Cat is Eating")
    }
}