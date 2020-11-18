/*
*
* Null safety operators -
* 1. Safe Call Operator -> ?.
* 2. Elvis -> ?:
* 3. Not null Assertion -> !!
* 4. Safe Call with let -> ?.let{..}
* */

fun main() {
    // In kotlin we cannot assign the "null" directly to any of the variable
    // to make the value nullable then we need to use
    // we can also create our own custom class and assign the instance to null
    val myNullString: String? = null
    val myIntNull: Int? = null

    // Null safety operators are discussed one by one

    // 1. Safe Call ( ?. )
    // returns the length if 'name' is not null else returns null
    // use it if you don't mind getting null value
    var name1: String? = null
    // by defining the variables as null we cannot apply the methods on it
    // if we want to apply the methods on it then we need to check for nullability with safe call operator
    println("The length of the name is ${name1?.length}")
    // the output will be shown as null because
    // on the right side of the variable is ignored that is ?.length will be ignored and null is printed is printed
    name1 = "Aditya"
    println("The length of the name is ${name1?.length}")
    // in the output the actual length of the name string is printed
    
    // 2. Safe Call with Let ( ?.let{} )
    // it executes its block if the value is not null
    val name2: String = "Aditya"
    name2?.let {
        println("The length of the name is ${name2.length}")
        // the actual length of the name will be printed
        // because the name2 is not null
        // if it is null then this block will not be executed
    }
    val name3: String? = null.toString()
    name3?.let {
        println("The length of the name is ${name3.length}")
    }

    // 3. Elvis operator ( ?: )
    // when we have nullable references 'name', we can say "is name is not null", use it,
    // otherwise use some non-null value
    val name4: String? = null
    val len = if (name4 != null) {
        name4.length
    } else {
        -1
    }
    // the above entire if expression can be replaced with the following statement
    // it means that the name4 is not null then return the length of the name4 else return -1
    val length = name4?.length ?: -1

    // 4. Non-null assertion operator ( !! )
    // use it when you are sure the value is NOT "null"
    // throws NullPointerException if the value is found "null"
    val name5: String? = null
    println("The length of the name is ${name5!!.length}")
    // if the name5 is not null and then the it prints the actual length of the String name5
}