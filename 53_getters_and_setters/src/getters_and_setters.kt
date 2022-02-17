/**
 * Getters and Setters in Kotlin
 *
 *
 */

fun main() {
    val person: Person = Person("Aditya", -1)

    person.name = "aditya"
    person.age = -1

    println(person.name + " " + person.age)
}

class Person constructor(nameParam: String, ageParam: Int) {

    var name: String = nameParam
        get() {
            return field.toUpperCase()
        }

    var age: Int = 0
        set(value) {
            if (value > 0) {
                field = value
            } else {
                println("Age can't be negative")
            }
        }

}