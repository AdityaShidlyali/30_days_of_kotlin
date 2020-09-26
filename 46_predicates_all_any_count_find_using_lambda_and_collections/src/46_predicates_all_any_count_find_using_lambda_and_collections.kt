/*
*
* Predicates or a Condition that returns true or false, those are :
* "all" - Do all elements satisfy the predicate/solution?
* "any" - Do any element in list satisfy the predicate ?
* "count" - Total number of elements that satisfy the predicate.
* "find" - returns the FIRST element that satisfy the predicate.
* */

fun main() {
    val myNumbersList: List<Int> = listOf<Int>(2, 3, 4, 8, 6, 23, 90)

    var check: Boolean
    // all method
    check = myNumbersList.all { num -> num > 10 } // are all elements greater than 10 ?
    // The above condition returns false as all the numbers in the list are not greater than 10
    println(check)

    // any method
    check = myNumbersList.any { it > 10 } // is any elements greater than 10
    // The above condition returns true
    println(check)

    // count method
    val count: Int = myNumbersList.count { it > 10 } // count the numbers whose value is greater than 10
    println(count)

    val firstNumberGreaterThan10: Int? = myNumbersList.find { num -> num > 10 }
    println(firstNumberGreaterThan10)

    // In kotlin we can store a lambda in a variable
    val myPredicate = { num: Int -> num > 10 }
    // and can be used for predicate functions
    myNumbersList.count(myPredicate)
}