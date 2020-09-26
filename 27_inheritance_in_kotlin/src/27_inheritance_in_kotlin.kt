// By default the classes in Kotlin are "public" and "final"
// To inherit any of the class the open keyword needs to be invoked.

/*

Types of inheritance allowed in Kotlin are :
1. Single Inheritance.
2. Multilevel Inheritance.
3. Hierarchical Inheritance.

All the class in Kotlin inherit the class 'Any'
> And 'Any' class contains functions such as :
    -> equals() : returns Boolean
    -> hasCode() : returns Int
    -> toString() : returns String
 */

fun main() {

    val dogO = Dog()
    val catO = Cat()

    dogO.breed = "PUG"
    dogO.color = "Brown"

    catO.breed = "American"
    catO.color = "Black"

    dogO.dogEats()
    catO.catEats()
}

open class Animal {
    var color: String = ""
    var breed: String = ""
}

class Cat : Animal() {
    fun catEats() {
        println("Cat Eats")
    }
}

class Dog : Animal() {
    fun dogEats() {
        println("Dog Eats")
    }
}