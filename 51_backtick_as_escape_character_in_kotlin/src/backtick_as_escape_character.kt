import java.util.*
import kotlin.math.max

/*
 * while taking the input in Java from the user we pass the System.in
 * to the Scanner class, here the "in" is keyword.
 *
 * So we also use the same thing in the Kotlin to take the user input
 * So we cannot use the "no" keyword in the Kotlin
 *
 * So to overcome this issue the backtick is used to - `
 *
 * Summary is that the backtick is used to make the inbuilt keywords as escape sequence.
 */

fun main() {

    var arrayList = arrayListOf<Int>()
    val maxValue: Int = 10
    for (i in 1..maxValue) {
        arrayList.add(i)
    }
    // here is the example where the in keyword is used
    for (i in arrayList) {
        println(i)
    }

    // taking input in Kotlin using System.in
    val scanner: Scanner = Scanner(System.`in`) // here the in keyword is backticked
    var item: Int = scanner.nextInt()
    println("The value is $item")
}