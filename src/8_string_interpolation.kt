fun main() {
    val firstName: String = "Aditya"
    var lastName: String = "Shidlyali"
    var fullName: String = "$firstName $lastName"

    println("First name = ${firstName} and Last name = ${lastName}")
    println("Full name = $fullName")

    println("First name length = ${firstName.length} and Last name Length = ${lastName.length}")
    println("length in total ${(firstName+lastName).length}")

    var o = Area()
    o.length = 2
    o.breadth = 10
    println("Length is ${o.length} and breadth is ${o.breadth} and the Area is ${o.length * o.breadth}")
}

class Area {
    var length: Int = 0
    var breadth: Int = 0
}