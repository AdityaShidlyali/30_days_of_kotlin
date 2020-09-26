/*
* FILTER - filters out desired elements from a collections.
* Returns a list containing only elements matching the given [predicate]. predicate takes in some value and returns boolean value
*
* MAP - performs operation, modify elements
* Returns a list containing the results of applying the given [transform] action
* to each element in the original collection.
* */

fun main() {

    // we will define the simple list to experiment the filter and map
    val myNumbers = listOf<Int>(1, 2, 6, 3, 10, 20, 30)

    // filter is used to filter the data based on certain condition.
    val mySmallNumbers = myNumbers.filter { n -> n < 10 } // or we can also use 'it' keyword as it contains only single parameter.
    for (i in mySmallNumbers) {
        print("$i ")
    }

    println()

    // map is used to perform the action on the elements of collections and return the same type of collection.
    val mySquaredNumbers = myNumbers.map { it * it } // or we can also use num -> num * num
    for (i in mySquaredNumbers) {
        print("$i ")
    }

    println()

    // we can also use the map and filter in the same context
    val myMixedOperationList = myNumbers.filter { it < 10 }.map { it * it }
    // the above operation filters the numbers less than value 10 and performs the square operation on them.
    for (i in myMixedOperationList) {
        print("$i ")
    }

    println()

    // filter and map using user defined class
    val people: List<Person> = listOf<Person>(Person(20, "Aditya"), Person(30, "Sam"), Person(40, "Achut"))
    val names = people.map { it.name }
    for (name in names) {
        print("$name ")
    }
    println()
    // to get the names which are starting with the letter A
    val namesWithA = people.filter { person -> person.name.startsWith('A') }.map { it.name }
    for (i in namesWithA) {
        print("$i ")
    }
}

class Person(var age: Int, var name: String) {

}