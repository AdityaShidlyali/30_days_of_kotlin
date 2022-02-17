import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

// Coroutines in Kotlin
// what are coroutines?
// Note: coroutines are not same as thread
/*
* On the main thread we can launch the small operations like:
* UI interaction(clicking button), some mathematical operations, lightweight logic operations.
*
* For Long operations like:
* network operations, file download, image loading, running heavy database queries
* if we launch these operations on the main thread the application will get freeze.
* Now for launching these operations we need to launch the background thread.
* It is also called as worker thread.
* This thread will run along with the main thread and will not interrupt main thread.
* But creating threads there is also limit. If we create more and more thread the application will also get
* hanged by out of memory.
*
* Here comes the coroutines
* Using a background thread launch some coroutines on that thread.
* Like uploading file, downloading file, or network operations.
*
* Basically Coroutines are the lightweight thread.
* Like threads Coroutines can also communicate with each other.
* The coroutines are free and we can create millions of coroutines.
* And we do not have to worry about the memory resources.
*/

fun main() {

    println("Main Program starts: ${Thread.currentThread().name}")
    // the way of launching the thread in Kotlin
    thread { // create a background thread (worker thread)
        println("Fake Work starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake Work starts: ${Thread.currentThread().name}")
    }
    println("Main Program starts: ${Thread.currentThread().name}")
    // in the above code from start to end the thread runs in background without interrupting the main thread

    // ------------------------------------------------------------------------------------------------------

    println("Main Program starts: ${Thread.currentThread().name}")
    // the way of launching the thread in Kotlin
    GlobalScope.launch { // create a background thread (worker thread)
        println("Fake Work starts: ${Thread.currentThread().name}")
        delay(1000)
        println("Fake Work starts: ${Thread.currentThread().name}")
    }
    println("Main Program starts: ${Thread.currentThread().name}")
    // in the above code from start to end the statements inside the launch functions will not show
    // because here the main thread will not wait for the coroutine

    // ------------------------------------------------------------------------------------------------------
    println("Main Program starts: ${Thread.currentThread().name}")
    // the way of launching the thread in Kotlin
    GlobalScope.launch { // operates within a thread
        println("Fake Work starts: ${Thread.currentThread().name}")
        Thread.sleep(1000)
        println("Fake Work starts: ${Thread.currentThread().name}")
    }
    Thread.sleep(2000)
    println("Main Program starts: ${Thread.currentThread().name}")
    // in the above code the output inside the launch function will be shown inside the console
    // as the main thread is waiting for 2sec. and between that the coroutine is finishing its work in 1sec.
    // but this is impractical because if there is work of uploading a file in the coroutine then
    // we don't know how much time to wait for the
    // thread.sleep() inside the launch function blocks the other coroutines

    // ------------------------------------------------------------------------------------------------------
    println("Main Program starts: ${Thread.currentThread().name}")
    // the way of launching the thread in Kotlin
    GlobalScope.launch {
        println("Fake Work starts: ${Thread.currentThread().name}")

        delay(1000) // this doesn't block the thread on which it is operating
        // this doesn't block the other coroutines running on the same thread

        println("Fake Work starts: ${Thread.currentThread().name}") // now this statement
        // may execute in the same thread or the other thread
    }
    Thread.sleep(2000)
    println("Main Program starts: ${Thread.currentThread().name}")
    // now delay is the suspend function, which needs to be written inside the coroutine block
    // we cannot write the delay function outside of the coroutine block

    // ------------------------------------------------------------------------------------------------------
    println("Main Program starts: ${Thread.currentThread().name}")
    // the way of launching the thread in Kotlin
    GlobalScope.launch {
        println("Fake Work starts: ${Thread.currentThread().name}")

        delay(1000) // this doesn't block the thread on which it is operating
        // this doesn't block the other coroutines running on the same thread

        println("Fake Work starts: ${Thread.currentThread().name}") // now this statement
        // may execute in the same thread or the other thread
    }
    runBlocking { // creates Coroutine that blocks the current main thread
        delay(2000) // wait for the coroutine to finish (mentioning delay is not that practical
        // because the coroutine of downloading a file may go any further execution)
    } // this blocks the thread, in which it operates
    println("Main Program starts: ${Thread.currentThread().name}")
    // NOTE: GlobalScope.launch() is non blocking in nature
    // and runBlocking{} blocks the thread in which it operates.

    // NOTE: entire code of the main method can be added inside the runBlocking{} method


    // now we can also create customized suspend function
}

suspend fun mySuspendFun(time: Long) {
    delay(time)
}