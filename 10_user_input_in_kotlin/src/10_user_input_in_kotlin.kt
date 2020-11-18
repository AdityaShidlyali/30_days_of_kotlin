import java.util.Scanner

fun main() {
    // The following function returns the line read or null
    var a = readLine()

    // This is one of the method to read the input and convert it to integer
    var b: Int = Integer.valueOf(readLine())

    // This is Java style reading method
    val input = Scanner(System.`in`)
    var i: Int = input.nextInt()
    var l: Long = input.nextLong()
    var s: String = input.next()
}