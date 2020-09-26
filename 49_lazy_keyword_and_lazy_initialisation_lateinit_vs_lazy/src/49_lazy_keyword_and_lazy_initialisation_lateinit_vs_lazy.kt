// during programming we initialise variables
// and some variables are left being not used.
// so the memory is wasted.
// in this case the lazy keywords comes in use.
// what it does is it loads the variable in cache memory
// only when its used for first time.
// once it loads the variable in cache memory then it can be used
// later part in the code by changing its value.

/*
* using lazy keyword with :
* nullable types
* var keyword
*
* and while using the above things we need to change the code accordingly.
* */

/*
* Some points on lazy initialization:
* 1. it is thread safe - it means it is initialized in the thread where it is used for the first time.
*       And if we are using in the lazy variable in some other thread, the value is loaded from the cache memory
*
* */

val pi: Float by lazy {
    3.14f // during defining no memory will be allocated for pi variable
    // means unless we use it in the program, the memory will not be allocated.
}

fun main() {

    // we are using pi variable for the first time
    // hence the variable will be allocated with some memory
    // in the cache memory
    val area1: Float = pi * 5 * 5

    // in the first usage the pi variable is already stored in the cache memory
    // and in the second usage the value is simply loaded from the cache memory.
    val area2: Float = pi * 10 * 10

}