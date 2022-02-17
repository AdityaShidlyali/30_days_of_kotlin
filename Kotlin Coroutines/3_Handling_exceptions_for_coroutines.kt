import kotlinx.coroutines.*

// Coroutine cancellation
/*
* Why coroutine to be cancelled?
* - The time taken for the coroutine is long to respond
* - Result no longer needed
*
* In order to cancel a coroutine,
* - The coroutine should be cooperative.
* - The cancel() method is need to called with the Job object
*
* Now if the coroutine fails to cancel the job.join() needs to be called,
* so that the coroutine can wait to finish its job.
* - so in case of using two functions we can ise the cancelAndJoin() function. When this is called,
* if the coroutine is cooperative then the coroutine is cancelled if not then it waits the coroutine to get its job finished.
*
* So how to make the coroutine cooperative?
* - Periodically invoke a suspending function that checks for cancellation.
* - Only those suspending functions that belongs to kotlinx.coroutines package will make coroutine cooperative. and therefore cancellable
* - the functions like delay(), yield(), withContext(), withTimeout() etc are the suspending functions that belongs to kotlin.coroutines package.
*
* We also need to handle the exception of coroutine cancellation
**/
fun main() = runBlocking {

    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job: Job = launch {
        for (i in 0..500) {
            print("$i.")
            Thread.sleep(50)
        }
    }
    delay(200)
    job.cancel()
    job.join()
    println("\nMain program ends: ${Thread.currentThread().name}")
    // in the above code the coroutine doesn't gets cancelled and will print all the values from 0 to 500 in 10 seconds.
    // because the above coroutine is not cooperative, as we are not using any functions from the kotlinx.coroutines package

    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job1: Job = launch {
        for (i in 0..500) {
            print("$i.")
            delay(50) // this belongs to kotlinx.coroutine package
            // so the delay function makes the coroutine cooperative and hence cancellable
        }
    }
    delay(200)
    job1.cancel() // this method cancels the coroutine after 200milisec.
    job1.join() // this method waits for the coroutine to get finish its work "only if not cancelled"
    println("\nMain program ends: ${Thread.currentThread().name}")
    // in the above code the coroutine is made cooperative be mentioning the delay inside the launch
    // so it gets cancelled after 200milisec.

    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job2: Job = launch {
        for (i in 0..500) {
            print("$i.")
            delay(50) // this belongs to kotlinx.coroutine package
            // so the delay function makes the coroutine cooperative and hence cancellable
        }
    }
    delay(200)
    job2.cancelAndJoin() // this replaces the cancel and join method, as it performs the
    // functionality of cancel and join methods. It cancels the coroutine and if coroutine
    // doesn't get cancelled then it waits for the coroutine to finish its work.
    println("\nMain program ends: ${Thread.currentThread().name}")

    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job3: Job = launch {
        for (i in 0..500) {
            print("$i.")
            yield() // this function is cancellable and it also doesn't delay the coroutine
        }
    }
    delay(200)
    job3.cancelAndJoin()
    println("\nMain program ends: ${Thread.currentThread().name}")

    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job4: Job = launch(Dispatchers.Default) {
        for (i in 0..500) {
            if (!isActive) {
                // isActive returns the boolean value after checking the coroutine cancellation status
                break
            }
            print("$i.")
        }
    }
    delay(200)
    job4.cancelAndJoin()
    println("\nMain program ends: ${Thread.currentThread().name}")
    // in the above code the coroutine gets executed even before cancelling it

    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job5: Job = launch(Dispatchers.Default) {
        for (i in 0..500) {
            if (!isActive) {
                // isActive returns the boolean value after checking the coroutine cancellation status
                Thread.sleep(20)
                break
            }
            print("$i.")
        }
    }
    delay(200)
    job5.cancelAndJoin()
    println("\nMain program ends: ${Thread.currentThread().name}")
    // in the above code the coroutine gets cancelled after 20millis

    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job6: Job = launch(Dispatchers.Default) {
        for (i in 0..500) {
            if (!isActive) {
                return@launch
            }
            print("$i.")
        }
    }
    delay(200)
    job6.cancelAndJoin()
    println("\nMain program ends: ${Thread.currentThread().name}")
    // in the above code the coroutine get executed for 200millis and then the isActive becomes true
    // and then the coroutine returns to the launch function and the coroutine gets stops

    /**
     * Handling Exception during the cancellation of coroutine
     *
     * when we cancel coroutine using suspending functions like yield, delay etc.
     * these functions throw CancellationException.
     *
     * we cannot execute a suspending function from the finally block, because the coroutine
     * running this code is already cancelled.
     *
     * If you want to execute a suspending function from a finally block then wrap the code
     * within withContext(NonCancellable) function.
     *
     * We can also print the custom cancellation message using
     * job.cancel(CancellationException("Custom message"))
     */
    //-----------------------------------------------------------------------------------------
    println("Main program starts: ${Thread.currentThread().name}")
    val job7: Job = launch(Dispatchers.Default) {
        try {
            for (i in 0..500) {
                if (!isActive) {
                    return@launch
                }
                print("$i.")
            }
        } catch (ex: CancellationException) {
            print("\nException caught safely")
        } finally {
            print("\nResources closed")
        }
    }
    delay(200)
    job7.cancelAndJoin()
    println("\nMain program ends: ${Thread.currentThread().name}")

    /**
     *
     * Timeouts in Coroutines
     *
     * if the coroutine is taking much time to finish its work then
     * we can cancel the coroutine.
     *
     * the kotlin provides two functions for timeouts
     * 1. withTimeout and 2. withTimeoutOrNull
     * these are also the coroutine builders just like launch and create functions,
     * these functions create coroutines.
     *
     * if the coroutine doesn't get finished after the specified time then these functions
     * throw TimeoutCancellationException
     */
    withTimeout(2000) {
        for (i in 0..500) {
            print("$i.")
            delay(500)
        }
    }
}