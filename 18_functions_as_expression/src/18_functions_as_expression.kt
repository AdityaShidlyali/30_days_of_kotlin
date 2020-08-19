fun main() {
    var maxValue: Int
    maxValue = findMax1(10, 20)
    println("The maximum value is $maxValue")

    maxValue = findMax2(90, 100)
    println("The maximum value is $maxValue")
}

fun findMax1(a: Int, b: Int): Int { // This is normal function returning the value
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun findMax2(a: Int, b: Int): Int =
        if (a > b) {
            print("$a is greater")
            a
        } else {
            print("$b is greater")
            b
        }