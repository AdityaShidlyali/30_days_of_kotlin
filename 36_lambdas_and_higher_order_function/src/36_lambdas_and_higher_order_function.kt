/*
* What are High level function or higher order function ?
* -> Can accept the function as parameter.
* -> Can return a function.
* -> Or can do both of things
* -> For example this type of things are used in the implementing setOnClickListener in Android
* Lambdas
* It is just a function with no name
* */

fun main() {
    // defining the simple object of the class
    val o1: Program = Program()

    // performing the addition using the simple OOP
    o1.addTwoNumbers(10, 20)

    // performing the addition of the sum using the interface by implementing all its methods
    // using the concept of anonymous class which is created here by "object : InterfaceName"
    o1.addTwoNumbers(10, 20, object : MyInterface {
        override fun execute(sum: Int) {
            println("The sum is $sum")
        }
    })

    // now performing the addition using lambda
    // here myLambda variable actually storing the lambda function which is of the type (Int) -> Unit
    // here the Int is the type of the input parameter which is required to be passed, which is stored in sum variable inside the lambda function.
    // here the sum is the argument which accepts the input parameter of the type Int.
    // the variable needs to be at the left side of the -> operator which is called as separator and the body of the lambda function needs to be at the right of it
    // here the println(sum) is the body of the lambda function.
    // in this case the return type is Unit as the println(sum) returns nothing, nothing in Kotlin means Unit is to invoked.
    val myLambda: (Int) -> Unit = { sum: Int -> println(sum) }
    o1.addTwoNumbers(10, 20, myLambda)

    // Returning Functions
    val func = operation() // 3
    println(func(2)) // 4
}

interface MyInterface {
    fun execute(sum: Int)
}

class Program {

    fun addTwoNumbers(
        a: Int,
        b: Int,
        actionToDo: (Int) -> Unit
    ) { // High level function with the lambda function as parameter.
        val sum: Int = a + b
        actionToDo(sum) // this is actually replaced by the body of the lambda that is in this case the println(sum)
    }

    fun addTwoNumbers(a: Int, b: Int, actionToDo: MyInterface) { // using interface / using object oriented way
        val sum: Int = a + b
        actionToDo.execute(sum)
    }

    fun addTwoNumbers(a: Int, b: Int) { // simply printing the sum using class method, using simple OOP
        println("The sum is ${a + b}")
    }
}

/** Returning Functions:
 * 1. Declares a higher-order function that returns a function. (Int) -> Int represents the parameters and return type of the square function.
 * 2. Declares a function matching the signature.
 * 3. Invokes operation to get the result assigned to a variable. Here func becomes square which is returned by operation.
 * 4. Invokes func. The square function is actually executed.
 */
fun operation(): (Int) -> Int { // 1
    return ::square
}

fun square(x: Int) = x * x // 2