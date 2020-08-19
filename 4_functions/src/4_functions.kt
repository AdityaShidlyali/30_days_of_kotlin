fun main(args: Array<String>) {
    var name: String = "Aditya Shidlyali"
    displayString(name)
    displayInt(20, 30)

    // to define the function with typical return type in kotlin, syntax is :
    // fun function_name(formal_parameters) : return_type { function_body with return statement}

    var area: Float = area(10.321f, 52.2342f)
    println("The area is $area")
}

fun displayString (name: String) {
    println("Your name is : $name")
}

fun displayInt (number1: Int, number2: Int) {
    println("Number 1 {$number1} Number 2 {$number2}")
}

fun area (length: Float, breadth: Float) : Float {
    return length * breadth
}

fun voidFunction (name: String) : Unit { // Unit represents Unit in Kotlin
    print("The string is $name")
}