fun main() {
    val o = Student()
    println("The student has passed : ${o.isScholar(20)}")

    val str1 = "Hello "
    val str2 = "World"
    val str3 = "Hey "

    println(str3.add(str1, str2))

    val x = 10
    val y = 20
    println("The greater number is ${x.findGreater(y)}")
}

// The following function is function member of our own class Student.
// This is called as extension functions.
// But however this is not the practical usage. To understand the extension function its just an example
fun Student.isScholar (marks: Int): Boolean {
    return marks > 50
}
class Student {
    fun isPassed(marks: Int): Boolean {
        return marks > 30
    }
}

fun String.add (s1: String, s2: String): String {
    return this + s1 + s2
}

fun Int.findGreater (other: Int): Int {
    return if (this > other) {
        this
    } else {
        other
    }
}