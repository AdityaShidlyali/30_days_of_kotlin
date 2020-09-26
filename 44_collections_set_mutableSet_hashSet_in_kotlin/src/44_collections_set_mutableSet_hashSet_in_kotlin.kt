/*
* Set in the Kotlin are same as that of the mathematical set.
* We can do the operation on the sets as we do in the operations on mathematical sets.
*
* It doesn't contains the duplicate elements
* */

fun main() {
    // simple immutable, fix sized set :
    val mySet: Set<Int> = setOf<Int>(12, 2, 32, 234, 23)

    for (i in mySet) {
        print("$i ")
    }

    println()

    // mutableSetOf in Kotlin
    val mySet2: MutableSet<Int> = mutableSetOf<Int>()
    mySet2.add(10)
    mySet2.add(30)
    mySet2.add(20)
    mySet2.add(100)

    for (i in mySet2) {
        print("$i ")
    }

    // we can also remove the elements based on the value
    mySet2.remove(100)

    println()

    // hashSetOf in Kotlin
    // hashSetOf returns the object of HashSet you can see below that mySet3 is of the type HashSet object
    // hashSetOf stores the element in random order
    val mySet3: HashSet<Int> = hashSetOf<Int>()
    mySet3.add(100)
    mySet3.add(200)
    mySet3.add(300)
    mySet3.add(400)

    for (i: Int in mySet3) {
        print("$i ")
    }
}