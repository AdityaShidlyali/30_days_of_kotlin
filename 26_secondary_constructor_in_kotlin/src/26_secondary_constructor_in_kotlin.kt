/*
* Kotlin can have only one primary constructor and
* one or more secondary constructor
* */

/*

Syntax :
class ClassName(variable1: type) {

    init {
        // Primary constructor body
    }

    // We need to call the primary constructor compulsorily
    // and pass the parameter id there is formal parameter in the primary constructor
    // and at this time the init block is optional
    constructor(variable1: type, variable3: type): this(variable1: type) {
        // Secondary constructor body
    }

 */

fun main() {
    val o = Person("Aditya Shidlyali", 10)
}

class Person(name: String) {

    init { // here the (Int) id is not accessible because it is the part of the secondary constructor.
        println("The name is $name")
    }

    constructor(name: String, id: Int) : this(name) {
        println("The name is $name and ID is $id")
    }
}