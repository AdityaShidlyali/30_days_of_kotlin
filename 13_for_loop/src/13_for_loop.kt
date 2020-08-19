fun main() {

    // The flow of the for loop is
    // Initialize -> Condition Check -> Code Execute -> Increment

    // The for in kotlin can be used to access the characters in the string and access the
    // items in the collections, ranges, iterators etc..

    for (i in 1..4) {
        print("$i ")
    }

    println()

    var name: String = "Aditya Shidlyali"
    for (i: Char in name) { // Char here is optional
        print(i)
    }

    println()

    for (i in 1..10 step 2) {
        print(i)
    }
}