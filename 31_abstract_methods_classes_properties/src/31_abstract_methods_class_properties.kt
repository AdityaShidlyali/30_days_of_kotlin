/*
* In Kotlin all abstract classes methods and properties are 'open' in nature.
* To invoke the abstract properties, methods, classes we need to invoke the 'abstract' keyword while declaration.
* If the class contains any abstract properties or methods the class needs to be declared as abstract.
* Abstract methods are having no body while declaring and they should be implemented inside the subclass.
* The instance of the abstract class cannot be created.
*
* Note: The non abstract method should and must contain the body while declaring or inheriting (it may be empty).
* */

fun main() {
    // we cannot instantiate the class Person
    // But we can instantiate the class Person_1

    val person1O = Person1()
}

abstract class Person {

    // we can override this method in multiple classes
    abstract fun firstName()
    open fun secondName() {}
}

class Person1 : Person() {

    // we must implement the methods and properties of the abstract class
    override fun firstName() {
        println("The firstName class of the Person_1")
    }

    // we can or cannot implement the method secondName() method, as it is not an abstract so its optional
}