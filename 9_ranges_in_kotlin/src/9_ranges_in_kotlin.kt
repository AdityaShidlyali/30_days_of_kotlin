fun main() {
    // The below range contains the numbers 1, 2, 3, 4, 5
    val r1 = 1..5

    // The below range contains 0, 1, 2, ... 10-1
    var r8: IntRange = 0 until 10

    // The below range contains the numbers 5, 4, 3, 2, 1
    val r2 = 5 downTo 1

    // The below range contains the number 10, 8, 6, 4, 2, 0
    // it simply takes the range with steps of two
    val r3 = 10 downTo 0 step 2

    // The below is same as above
    val r4 = 0..10 step 2

    // We can also have the character ranges
    val r5 = 'a'..'z' // or r5 = 'A'..'Z'
    // is different from "a".."z" or "A".."Z"

    // we can also check whether the character is present in the range or not
    var isPresent = 'c' in r5
    print(isPresent)

    // The below range contains the numbers 10, 9, 8, 7,.... 1
    var r6 = 20.downTo(1)

    // The below range contains the numbers 1, 2, 3, ....10
    var r7 = 1.rangeTo(10)
}