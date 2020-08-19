fun main() {

    // Syntax :
    /*
    * do {
    *  body
    * } while (condition)
    * */

    // Flow of execution :
    // Code execute -> Increment -> Condition check

    var i: Int = 1
    do {
        i++
        println(i)
    } while (i <= 10)

}