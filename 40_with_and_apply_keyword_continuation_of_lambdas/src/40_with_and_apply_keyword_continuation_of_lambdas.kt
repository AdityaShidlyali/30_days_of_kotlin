/*
* By using 'with' and 'apply' keyword, the code redundancy can be reduced
*
* 'with' and 'apply' are the Kotlin standard library
* */

fun main() {
    val o: Person = Person()

    // when we create the object of the class we need to deal with its properties and members individually
    // which increases the number of lines of code.
    o.name = "Aditya"
    o.age = 20
    println(o.name)
    println(o.age)

    // by using 'with' we can see that the lines of the code can be reduces and we can instantiate the members of the class
    // but we cannot access the methods inside the class.
    with(o) {
        name = "Aditya Shidlyali"
        age = 20
    } // The curly brace is actually the
    println(o.name)
    println(o.age)

    // similarly we can use the 'apply', by using this we can instantiate the members of the class
    // and we can call the methods of the class
    // apply returns the a receiver and in this case the receiver is the 'o' which is the class object
    o.apply {
        name = "Aditya Shidlyali"
        age = 20
    }.displaySomething()
    println(o.name)
    println(o.age)
}

class Person {
    var name: String = ""
    var age: Int = 0

    fun displaySomething() {
        println("This is the function inside the Person class")
    }
}