/*
* Interface are created with the keyword 'interface'
* All methods and properties of interface are by default 'open'(non final) and 'public'.
* In interface the properties cannot be initialised, but the methods can be initialised with their body (if the method is not abstract).
* */

fun main() {
    val indianO = Indian()
    indianO.firstName()
    indianO.lastName()
    indianO.getOrigin()
}

interface Person {
    var firstname: String
    var lastname: String

    // If the method is abstract in interface the body of the method shouldn't be there or if that contains the
    abstract fun firstName()

    // The body of the normal, open and non abstract function may or may not contain the body.
    fun lastName()

    // if this method needs to overridden and also to be called then in overridden class we need to invoke super.methodName()
    fun getOrigin() {
        println("He is an Indian")
    }
}

class Indian : Person { // as interface cannot be instantiated while implementing it the primary constructor call must be removed unlike in classes
    override var firstname: String = "Aditya"
    override var lastname: String = "Shidlyali"

    override fun firstName() {
        println("First name is $firstname")
    }

    override fun lastName() {
        println("Last Name is $lastname")
    }

    override fun getOrigin() {
        println("$firstname $lastname is an Indian")
        super.getOrigin()
    }
}