/*
 * The Kotlin standard library contains several functions whose sole purpose is to execute a block
 * of code within the context of an object. When you call such a function on an object with a
 * lambda expression provided, it forms a temporary scope. In this scope, you can access the
 * object without its name. Such functions are called scope functions.
 *
 * There are 5 types of scope functions in kotlin
 * 1. with    2. let    3. run    4.apply    5. also
 *
 * Major difference in the scope functions is
 * -> The way to refer to the  | -> The return value
 * context object.             |    either 'context object'
 * either 'this' or 'it'       |    or the 'lambda result'
 *
 * Following are the scope functions with their returns
 * with -> returns 'lambda result' and context object is 'this'
 *
 */

fun main() {

    //================================
    /*
    * Scope function: 'with'
    * Property 1: Refer to context object by using 'this'
    * Property 2: The return value is 'lambda result'
    * */
    val person1: Person = Person()
    // the person1 will get the name as ADITYA and age with increment of 5
    with(person1) {
        // we can refer the members using "this.name" and "this.age"
        name = "ADITYA"
        age += 25
    }
    // we can also assign the value of the with function
    val age1: Int = with(person1) {
        age + 5
    }

    //================================
    /*
    * Scope function: 'apply'
    * Property 1: Refer to the context object by using 'this'
    * Property 2: The return value is 'context object'
    * */
    val person2: Person = Person().apply {
        this.name = "Aditya Shidlyali"
        this.age += 25
    }
    // we can also do it by person2.apply {}

    //================================
    /*
    * Scope function: 'also' defines - ALSO PERFORM THE FOLLOWING OPERATIONS
    * Property 1: Refer to the context object by using 'it'
    * Property 2: The return value is 'context object'
    * */
    // this is helpful in which there is further code or function call
    val numbersList: MutableList<Int> = mutableListOf(1, 2, 3)
    val numbersList1 = numbersList.also {
        println("The numbers list is: $numbersList")

        numbersList.add(100)
        println("The numbers list is: $numbersList")

        numbersList.remove(2)
        println("The numbers list is: $numbersList")

        // instead of numbersList object we can use 'it'
    }
    println(numbersList1)
    // we can use the 'also' with the custom classes too
    val person3: Person = Person().also {
        it.name = "ADITYA SHIDLYALI"
        println(it.name)
    }

    //================================
    /*
    * Scope function: 'let'
    * Property 1: Refer to the context object by using 'it'
    * Property 2: The return value is 'lambda result'
    *
    * Note: Use 'let' function to avoid NullPointerException
    * */
    val name: String? = "Aditya Shidlyali"
    // println(name!!.reversed())
    // println(name!!.capitalize())
    // using the '!!' operator to get rid off the nullable objects
    // we use it many times, to avoid NullPointerException if there are many
    // functions to be performed on the Nullable object we use let
    val stringLength: Int? = name?.let {
        println(it.reversed())
        println(it.capitalize())

        it.length
        // by doing this we will not get the NullPointerException
        // this body executes only when the object is not null
    }

    //================================
    /*
    * Scope function: 'run'
    * Property 1: Refer to the context object by using 'this'
    * Property 2: The return value is 'lambda result'
    *
    * The special about the run function is, is a combination of with and let function
    * If developer wants to operate on Nullable object and avoid NullPointerException then use 'run' function
    * */
    val person4: Person? = Person() // the Person() can be null also
    val age: Int? = person4?.run {
        println(name)
        println(age)
        age + 5
    }

    /**
     * Summary:
     *
     * with: If you want to operate on a non-null object.
     * let: If you want to just execute lambda expression on a nullable object and avoid
     *      NullPointerException.
     * run: If you want to operate on a Nullable object, execute lambda expression and avoid
     *      NullPointerException.
     * apply: If you want to initialise or configure an object.
     * also: If you want to do some additional object configuration or operations.
     *
     */
    30days of Kotlin learning
}

class Person {
    var name: String = ""
    var age: Int = 0
}