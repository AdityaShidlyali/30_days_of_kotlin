fun main() {
    // The following call of parameters are serially with formal parameters.
    findVolume(length = 10, breadth = 20, height = 30)

    // The following call with parameters are not serially with formal parameters.
    // Here named parameters will help to match the formal parameters.
    findVolume(height = 10, length = 20, breadth = 30)
}

fun findVolume (length: Int, breadth: Int, height: Int) {
    println(length * breadth * height)
}