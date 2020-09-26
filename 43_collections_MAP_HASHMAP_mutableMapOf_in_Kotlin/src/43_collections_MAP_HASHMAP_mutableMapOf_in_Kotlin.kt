/*
*
* the general and simple map in Kotlin are immutable and fixed in size
*
* syntax to define map are :
* var/val myMap: Map<Type, Type> = mapOf<Type, Type>()
*
* To map the key to value we use the keyword 'to' (only in Map).
*
* HashMap in Kotlin are the
*
* */

fun main() {
    val myMap: Map<Char, Int> = mapOf<Char, Int>('a' to 10, 'b' to 20, 'c' to 30)

    for (key: Char in myMap.keys) {
        print("Element at $key = ${myMap.get(key)}\n") // we can also use myMap[key] to print its values
    }

    println()

    var myMap2: HashMap<Char, Int> = HashMap<Char, Int>()
    // we need to define the HashMap explicitly in Kotlin
    myMap2.put('a', 100)
    myMap2.put('b', 200)
    myMap2.put('c', 300)
    myMap2.put('d', 400)

    for (key in myMap2.keys) {
        println("Element at $key = ${myMap2[key]}")
    }
    // we can replace the value related to key in maps
    myMap2.replace('c', 300) // or we can use put method that works as well

    // we can also use the mutableMapOf or hashMapOf in Kotlin it just works same as that of the HashMap
    // here the difference is the mutableMapOf returns LinkedHashMap
    // syntax of mutableMapOf :
    // var/val myMap = mutableMapOf<Type, Type>()
    // syntax of hashMapOf :
    // var/val myMap = hashMapOf<Type, Type>()
}