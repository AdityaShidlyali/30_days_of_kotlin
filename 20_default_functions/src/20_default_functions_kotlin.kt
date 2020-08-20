@file: JvmName("volume_function_kotlin")

fun main() {
    // For this call the default value of the height is 100
    var result1 = findVolume(10, 20)
    println("The volume is $result1")

    // For this call the value of the height value will be overriden
    var result2 = findVolume(10, 20, 30)
    println("The volume is $result2")
}

// Here the default value of the height is 100 and if we pass the value of the height
// it overrides the value of height, and dosen't gives error. This is only supported in Kotlin.
// in java this type of feature gives error.
// But we can overcome the limit of overriding in java by calling the function of
// Java, by calling the Kotlin functions, that is using interoperability.

@JvmOverloads // This helps the java to skip the default parameter passing.
fun findVolume(breadth: Int, length: Int, height: Int = 100): Int {
    return length * breadth * height
}