/*
Class and its syntax :
class class_name {
    // class body
}

// The following is the class constructor
class class_name (variable: datatype) {
    init {
        // to initialise the class variables
    }
}
 */

/*
There are some Property in Kotlin also known as field variable.

For Primary Constructors there are :
-> init block.
-> primary constructor with property.
-> primary constructor with just parameters.

 */

fun main() {
    // To instantiate the class we use :
    // var or val(val is preferred) objectName = class_name()
    val o = Student()
    o.name = "Aditya Shidlyali"
    println("Name is : ${o.name}")
}

class Student {
    var name: String = ""

    init {
        // This block will be executed as soon as we instantiate the class
        println("The name in init block is : $name")
    }
}