fun main(args: Array<String>) {
    var name: String = "Aditya Shidlyali"
    displayString(name)
    displayInt(20, 30)
}

fun displayString (name: String) {
    println("Your name is : $name")
}

fun displayInt (number1: Int, number2: Int) {
    println("Number 1 {$number1} Number 2 {$number2}")
}