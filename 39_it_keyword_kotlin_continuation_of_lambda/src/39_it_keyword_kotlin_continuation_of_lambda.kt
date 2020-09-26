/*
* the 'it' keyword is used, where the lambda expression receives only one parameter.
*
* */

fun main() {

    // create object of the class
    val o: PerformReverseOfString = PerformReverseOfString()

    // the example where there is single parameter to be passed in the lambda expression
    o.performReverse("Hello") { s: String -> s.reversed() }

    // This is where the 'it' keyword comes into picture
    // where in the above case we have seen that the string "hello" is only one input for the lambda function
    // we can replace the s: String -> s.reversed() to it.reversed()
    // 'it' keyword accepts any type of the data
    o.performReverse("Hello") { it.reversed() }
}

class PerformReverseOfString {
    fun performReverse(s: String, myFuncToReverseString: (String) -> String) {
        // below myFuncToReverseString(s) is replaced and interpreted as s.reversed() which gives "olleH" in this case
        var result: String = myFuncToReverseString(s)
        println("The reversed string is $result")
    }
}