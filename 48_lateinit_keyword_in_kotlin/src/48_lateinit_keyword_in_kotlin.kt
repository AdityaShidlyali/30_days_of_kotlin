/*
* 'lateinit' keyword is used only :
* mutable data type [ var ].
* non-nullable data type. (that is String?)
* must be initialised before we use it.
* */

fun main() {
    val o: Country = Country()

    // we will get the UninitialisedPropertyException if not initialised
    o.name2 = "India"
    println(o.name2)
}

class Country {
    // the compiler gives error if the String variables are not initialised.
    // but application to application the requirements changes and we might
    // not want to initialise the variable initially.
    // either it need to be initialised with the null or we have give some value.
    var name1: String = ""

    // but on using the variable with the lateinit we need to initialise the variable
    // later, if we access this without initialising we will get the UninitialisedPropertyException
    lateinit var name2: String
}