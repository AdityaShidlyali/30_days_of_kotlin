/*
* Simple array syntax in Kotlin is :
* var/val arrayVariableName: Array<Type> = Array<Type>(size){value_to_be_initialised}
*
* Array in Kotlin are mutable and fix sized.
* */

fun main() {
    var n: Int = readLine()?.toInt()!!
    var myArray: Array<Int> = Array<Int>(n) { 0 }

    var i: Int = 0
    var ele: Int
    for (i: Int in 0 until n) {
        ele = readLine()?.toInt()!!
        myArray[i] = ele
    }

    // One way of printing array elements
    println("The entered elements are : ")
    for (i: Int in 0 until n) {
        print("${myArray[i]} ")
    }

    println()

    // another way of printing the array elements
    println("The entered elements are : ")
    for (i in myArray) {
        print("$i ")
    }

    println()

    // One more way of printing the array elements
    println("The entered elements are : ")
    for (i in 0..myArray.size - 1) {
        print("${myArray[i]} ")
    }
}