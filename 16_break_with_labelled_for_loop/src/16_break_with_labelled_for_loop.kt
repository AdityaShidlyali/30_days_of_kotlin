fun main() {
    var i: Int = 1
    while (i <= 10) {
        if (i == 6) {
            break // this is the normal unlabelled break statement
        }
        print(i)
        i++
    }

    println()

    myLoop@ for (i in 1..10) {
        for (j in 1..10) {
            if (i == 5 && j == 5) {
                break@myLoop // this is the labelled break statement
            }
            println("$i $j")
        }
    }
}