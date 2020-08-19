fun main() {
    // syntax
    // while (condition) { while body }

    // Flow of execution :
    // Condition check -> Code Execute -> Increment

    var i: Int = 1
    while (i <= 10) {
        print("$i ")
        i++
    }

    println()

    while (i <= 10) {
        if (i % 2 == 0) {
            print("$i ")
        }
        i++
    }
}