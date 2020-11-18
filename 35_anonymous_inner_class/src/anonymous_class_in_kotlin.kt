/*
* In java we create an interface and declare the method
* without initialising it...
*
* and then we create instance of the interface and object of the type interface
* inside the object we override the functions of the interface and initialise them
* with that object we initiate the functions to execute.
* */

interface Human {
    fun think()
}

fun main() {
    val programmer: Human = object : Human {
        override fun think() {
            println("Think virtually")
        }
    }

    programmer.think()
}