// All infix functions are extension functions.
// But all extension functions are not extension functions.

// One guideline to use the infix functions is, the functions must contain only one parameter.

fun main() {
    val x = 10
    val y = 20
    println("The greater number is ${x.findGreater(y)}")

    // The following usage is only possible only when the function is infix.
    // The more advantages of the infix function will be in the function overloading.
    val result: Int = x findGreater y
    println("The greater value is $result")
}

// The following function is infix function and extension function too.1
infix fun Int.findGreater (other: Int): Int {
    return if (this > other) {
        this
    } else {
        other
    }
}