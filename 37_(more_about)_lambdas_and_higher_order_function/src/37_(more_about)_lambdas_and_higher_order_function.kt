import java.util.function.Consumer

/*
* syntax of the lambda function :
*
*    parameters of
*    the lambda
*    function  and   lambda method body
*         ^                ^
*         |                |
*         |                |
*       { x, y     ->     x + y }
*
* To assign a this lambda function to the variable syntax is :
* val myLambdaVariable: (Int, Int) -> Int = {x, y -> x + y}
*
* '->' is called separator which separates the parameter and the function body.
* (Int, Int) is the type of the arguments needs to be passed to the lambda function.
* x + y is action performed by the lambda function which is actually the body of the lambda function.
*
* Now calling lambda function through the higher order function the syntax is :
* addTwoNumbers(10, 20, myLambdaVariable) // this is actually the high level function.
*
* Now defining the higher order function
* fun addTwoNumbers (a: Int, b: Int, customVariableFunctionName: (Int, Int) -> Int) { // here the (Int, Int) -> Int is the return type of the lambda function.
*       var result = customVariableFunctionName(a, b) // x + y = a + b = 10 + 20 = 11
*       println(result)
* // addTwoNumbers Body ends here
* }
*
*
* */

fun main() {
    val o: PerformAddition = PerformAddition()

    val myLambdaAddition: (Int, Int) -> Int = { x, y -> x + y }
    // First method of calling the lambda function
    o.performAddition(10, 20, myLambdaAddition)

    // second way of calling the function
    o.performAddition(10, 20, { x, y -> x + y })

    // third way of calling the lambda function
    // here we cannot replace { x, y -> x + y } with the variable myLambdaAddition
    o.performAddition(10, 20) { x, y -> x + y } // it looks like the body of method


    // ------------------
    // another best example for the lambda function or the higher order function is
    var myList = arrayListOf<Int>(1, 2, 3, 4, 5)
    // there are two types of printing the values of myList one is using for loop and one more is forEach method
    myList.forEach({ println(it) })
    // for each is the method and we are passing function to a function
    // understanding how it works :
    // now forEach method which needs the Consumer(interface) object
    var myConsumerObject: Consumer<Int> = object : Consumer<Int> {
        override fun accept(t: Int) {
            TODO("Not yet implemented")
            println(t)
        }
    }
    // the concept of boiler plate code comes into picture
    // here in this case we know that myConsumerObject is the type of Consumer<Int>
    // then why again we need to mention "object : Consumer<Int>
    // this is called as boiler plate code and also the Consumer interface has only one method
    myList.forEach(Consumer { t ->
        println(t)
    })
    // so instead of doing all the Consumer interface implementation
    // we can do the following thing
    myList.forEach({ t -> println(t) }) // we can use any variable name other than "t"
    // even there is better way to write it
    myList.forEach({ println(it) })
    // even the better way to print is using "::" (method reference operator)
    myList.forEach(::println)
    // and we can also mention the class name before the method referencing operator
    // like myList.forEach({ClassName :: functionName })
}

class PerformAddition {
    fun performAddition(a: Int, b: Int, higherOrderFunctionAddition: (Int, Int) -> Int) { // here the (Int, Int) -> Int can also be called as the signature of the function.
        var result: Int = higherOrderFunctionAddition(a, b) // higherOrderFunctionAddition(a, b) will be x + y = a + b = 10 + 20 = 30
        println("The sum is $result")
    }
}