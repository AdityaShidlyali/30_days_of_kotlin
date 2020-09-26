fun main() {

}

open class B {
    var name: String = ""
}

interface Person {
    var name: String
}

class customClass : Person, B() {
    
}