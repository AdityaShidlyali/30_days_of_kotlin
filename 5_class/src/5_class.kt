fun main (args: Array<String>) {
    var name: String = "Aditya Shidlyali"
    var o = Person ()
    o.displayName(name)

    // We can also access and change the variables in the class
    o.setName = "Hello World"
    o.displaySetName()
}

class Person {
    var setName: String = ""

    fun displayName(name: String) {
        println("Your name is : $name")
    }

    fun displaySetName() {
        print("Set name : $setName")
    }
}