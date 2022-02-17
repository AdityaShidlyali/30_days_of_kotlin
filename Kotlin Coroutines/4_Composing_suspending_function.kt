import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * Composing Suspending Functions
 *
 * The coroutines can be executed in
 * 1. Sequential
 * 2. Concurrent
 * 3. Lazy Execution
 *
 * The coroutine functions in kotlin are sequential by default.
 * We can also make them concurrent by making them to execute in parallel.
 */
fun main() = runBlocking {
    // the coroutines and all the functions within the runBlocking body are executed sequentially.

    println("Main program starts: ${Thread.currentThread().name}")

    val time = measureTimeMillis { // this measures the time taken to execute the code
        val msgOne: Deferred<String> = async { getMessageOne() }
        val msgTwo: Deferred<String> = async { getMessageTwo() }
        // instead of async we can also use the launch coroutine builder which executes the coroutine
        // in parallel.
        // by asynchronising the these tasks both function we can get the result in 1millis.
        println("The entire message is ${msgOne.await() + msgTwo.await()}")
    }
    println("Time taken to execute $time millis")

    println("Main program ends: ${Thread.currentThread().name}")

    //--------------------------------------------------------------------------------
    val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOne() }
    val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageTwo() }
    // in the above two lines the variables msgOne and msgTwo are not used anywhere in the program
    // so we can make the coroutine execution lazy, as coroutine should only start if the resources
    // are used in the program further otherwise the coroutines shouldn't execute
}

suspend fun getMessageOne(): String {
    delay(1000L)
    return "Hello"
}

suspend fun getMessageTwo(): String {
    delay(1000L)
    return "World"
}