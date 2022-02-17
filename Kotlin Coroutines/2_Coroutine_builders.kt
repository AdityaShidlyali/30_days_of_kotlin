import kotlinx.coroutines.*

// Coroutines Builders in Kotlin
/*
*
* What are coroutines?
* - The name implies the functions, using which we create coroutines.
*
* The coroutine builders in Kotlin are:
* 1. launch     2.async    3.runBlocking
*
* 1. launch{}
* In this we mainly have the GlobalScope.launch{} in which the GlobalScope is Companion Object.
* In this we have the GlobalScope.launch{} and the launch{}.
* The main difference is that the launch{} has the scope over the activity. If the activity is destroyed the coroutine of the launch is also destroyed
* This launch creates a coroutine in the local scope.
* If we create a coroutine in the GlobalScope the coroutine will be at the GlobalData(app) level. Survives the entire lifecycle of the application.
*
* 2. async
* In this we have the GlobalScope.async{} in which the GlobalScope is Companion Object.
*
* 3. runBlocking{}
* This is the lambda function itself.
*
*/
fun main() = runBlocking {
    // ------------------------------------------------------------------------------------------------------
    println("Main Program starts: ${Thread.currentThread().name}")
    // with the GlobalScope.launch the coroutine is running under the "worker" thread
    GlobalScope.launch {
        println("Fake Work starts: ${Thread.currentThread().name}")

        delay(1000)

        println("Fake Work starts: ${Thread.currentThread().name}")
    }
    Thread.sleep(2000)
    println("Main Program starts: ${Thread.currentThread().name}")

    // ------------------------------------------------------------------------------------------------------
    println("Main Program starts: ${Thread.currentThread().name}")
    // with the GlobalScope.launch the coroutine is running under the "main" thread
    // because the main function is with the runBlocking and the runBlocking runs under the
    // main thread. So this coroutine inherits the scope of parent coroutine
    // And also of the runBlocking runs on the thread T1, also the child coroutine runs on the T1 thread
    launch {
        println("Fake Work starts: ${Thread.currentThread().name}")

        delay(1000)

        println("Fake Work starts: ${Thread.currentThread().name}")
    }
    Thread.sleep(2000)
    println("Main Program starts: ${Thread.currentThread().name}")
    // in the above code inside the launch function the statements before the delay function executes in one thread,
    // let say T1 thread, and statements after the delay function get executed in another thread let 
    // say T2 or some thread.

    // ------------------------------------------------------------------------------------------------------
    println("Main Program starts: ${Thread.currentThread().name}")
    // the launch function returns the object of type Job
    // so by using the object of the job we can control the coroutine
    val job: Job = launch {
        println("Fake Work starts: ${Thread.currentThread().name}")

        delay(1000)

        println("Fake Work starts: ${Thread.currentThread().name}")
    }
    // Thread.sleep(2000)
    job.join() // this can be used instead of delay
    // this join function function waits for the one coroutine to finish its execution of another
    // the coroutine can also be cancelled using job.cancel() method
    println("Main Program starts: ${Thread.currentThread().name}")

    // ------------------------------------------------------------------------------------------------------
    println("Main Program starts: ${Thread.currentThread().name}")
    // the async will inherit the coroutine scope from the immidiate parent coroutine which is runBlocking
    val jobDeferred: Deferred<Unit> = async {
        println("Fake Work starts: ${Thread.currentThread().name}")

        delay(1000)

        println("Fake Work starts: ${Thread.currentThread().name}")
    }
    jobDeferred.join()
    println("Main Program starts: ${Thread.currentThread().name}")
    // the main difference between the async and launch is the async returns the Deferred class object
    // which is the subclass of the Job
    // but using the async function we can also return the values and retrieve the values using the await method of Deferred object
    // This async launches the coroutine without blocking the current thread.
}

// this suspending function can only be run inside the runBlocking body
suspend fun myOwnSuspendingFunc() {
    delay(1000)
}