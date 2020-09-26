/*
* All functions and the classes declared outside the class are public by default
*
* Visibility modifiers in Kotlin are :
* 1. public - accessible in entire project
* 2. private - accessible within only one class file
* 3. protected - this is not applicable for top level functions, applicable for only for methods and properties of the
*                class.
* 4. internal - accessible within only one module or project
* */

fun main() {

}

open class Base {

    var a: Int = 10 // no need to invoke public as it is public by default
    private var b: Int = 20
    protected var c: Int = 30
    internal var d: Int = 40

}

class class1 : Base() {
    // a, c, d are accessible
    // b is inaccessible
}

class class2 {
    // a, d are accessible
    // b, c are inaccessible
}