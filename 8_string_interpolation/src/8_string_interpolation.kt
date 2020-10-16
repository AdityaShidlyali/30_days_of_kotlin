class valueB {
    var b: Int = 20
}

fun main() {

    var a: Int = 10
    // the $ operator informs the there is variable in the string
    println("The value of a is $a")

    val o: valueB = valueB()
    // this same can be $ with {} can be used to add the encapsulated objects
    // and same can be printed through println function
    println("The value of b is ${o.b}")
}