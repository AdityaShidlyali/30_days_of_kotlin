fun main() {
    for (i in 1..10) {
        if (i == 5) {
            continue // This is the normal unlabelled continue statement
        }
        print("$i ")
    }

    println()
    outerLoop@ for (i in 1..5) {
        for (j in 1..5) {
            if (i == 3 && j == 3) {
                continue@outerLoop
            }
            println("$i $j")
        }
        println()
    }
}