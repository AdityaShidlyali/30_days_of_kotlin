fun main() {
    var a = 10
    var b = 20
    var maxValue = 0
    // This is the typical if else control statement
    if (a > b) {
        maxValue = a
    } else {
        maxValue = b
    }
    println("The maximum value is $maxValue")

    // The following is the if expression or if as expression
    // if there are multiple lines of code in the if or else block then the value at the last will be returned
    // and will be assigned to the variable.
    var Value: Int = if (a > b) {
        a
    } else {
        b
    }
    println("The value is $Value")

}