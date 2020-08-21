import java.math.BigInteger

// TAILREC function is an optimized way of having the recursive function.
// The tailrec function in kotlin prevents Stack overflow.

// we have to use the keyword "tailrec" to have the TAILREC function in kotlin.

fun main() {
    println("The fibonacci number at 10000th position is : ${getFibonacci(10000, BigInteger("2"), BigInteger("100"))}")
}

tailrec fun getFibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    if (n == 0) {
        return b
    } else {
        return getFibonacci(n-1, a + b, b)
    }
}