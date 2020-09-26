/*
* In Java 8 we cannot mutate(change) values of the outside variable inside the lambdas.
* But in Kotlin we can change the values of the outside variable within lambda function.
* */

fun main() {

    val o: PerformAddition = PerformAddition()

    // result is the outside variable here in this case
    var result = 0

    // result is the outside variable, in which Kotlin allows to change the value of the outside variable within the lambda function
    val myLambda: (Int, Int) -> Unit = { x, y -> result = x + y }
    o.performAddition(10, 20, myLambda)

    // now print the changed value of the outside variable that is result in this case
    // This is called the CLOSURE
    println("The sum is $result")
}

class PerformAddition {
    fun performAddition(a: Int, b: Int, higherOrderFunctionAddition: (Int, Int) -> Unit) {
        higherOrderFunctionAddition(a, b)
    }
}