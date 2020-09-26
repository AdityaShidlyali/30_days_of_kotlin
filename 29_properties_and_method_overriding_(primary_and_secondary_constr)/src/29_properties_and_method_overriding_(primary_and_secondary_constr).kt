fun main() {
    val dogO = Dog("Black", "PUG")

    val catO = Cat("White", "American")
}

// Demo of the overriding in case of primary constructor
// where the class Animal1 is base class and Dog is the derived class
open class Animal1(var color: String) {
    init {
        println("The animal is $color")
    }
}

class Dog(color: String, var breed: String) : Animal1(color) {
    init {
        println("The Dog is $color breed is $breed")
    }
}

// Demo of the overriding in case of primary constructor
// where the class Animal2 is base class and Cat is the derived class

open class Animal2() { // if it would be Animal2() then, in constructor below should invoke "constructor (parameters) : this() {}"
    // although the primary constructor is with the empty parameters then this call must be also empty
    var color1: String = ""

    constructor(color1: String) : this() {
        this.color1 = color1
    }
}

class Cat : Animal2 {
    var breed: String = ""

    constructor(color1: String, breed: String) : super(color1) {
        this.breed = breed
    }
}