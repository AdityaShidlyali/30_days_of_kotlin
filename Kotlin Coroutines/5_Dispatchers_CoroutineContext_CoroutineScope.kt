import kotlinx.coroutines.runBlocking

/**
 * CoroutineScope, CoroutineContext, Dispatchers.
 *
 * CoroutineScope:
 * 1. Any coroutine builder function when it gets executed it get attached to some coroutine scope.
 * 2. Each coroutine has one CoroutineScope instance attached to it.
 * 3. Each coroutine builder also has a CoroutineScope attached to it.
 *
 * CoroutineContext:
 * 1. Similar to CoroutineScope, every coroutine has CoroutineContext of its own.
 * 2. CoroutineContext has two major components those are: Job and Dispatcher.
 * 3. Dispatcher decides on which thread the coroutine should execute.
 * 4. Job: it is object which we can control the coroutine.
 * 5. Apart from these we can also assign the name to the coroutine.
 *
 * Dispatcher are of 4 types:
 * 1. Default
 * 2. Unconfined
 * 3. Main : in this the coroutine gets executed in the UI thread.
 * 4. IO : in this the coroutine executed for IO operation.
 */

fun main() = runBlocking {
    // this -> CoroutineScope instance
    // coroutineContext -> CoroutineContext instance

    // Coroutine without parameter, also called as Confined coroutine.
    // like below is the coroutine without any parameters.
    // launch { } this will inherit the CoroutineContext that is it will inherit the Dispatcher
    // from the immediate parent coroutine that is runBlocking.

    // if we use the launch(Dispatchers.Default) {}, This will create a coroutine whose properties
    // will be exactly same as the coroutine created by GlobalScope.launch function. That is this coroutine
    // will be created at the application level, hence it will execute on separate background thread.

    // if we use the launch(Dispatcher.Unconfined){}, This will inherit the CoroutineContext from the immediate
    // parent that is runBlocking, so this coroutine will get execute on the main thread.
    // But if we include the suspending function inside this then the statements after the suspending function
    // get execute on the seperate thread, not the main thread.

    // if we use the launch(coroutineContext){}, here the coroutineContext is the context of the immediate parent
    // so this type of coroutine will get executed in the thread of the parent coroutine.
}