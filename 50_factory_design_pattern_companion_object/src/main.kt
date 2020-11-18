class A {
    companion object {

        // this can also be written as :
        // fun create(): A = A()
        fun create(): A {
            return A()
        }
    }

    fun show() {
        print("Show function")
    }
}

fun main() {

    // instead of creating the constructor of the class
    // we can create the factory method create which returns the class constructor itself or the instance of the class
    val o: A = A.create()
    o.show()
}