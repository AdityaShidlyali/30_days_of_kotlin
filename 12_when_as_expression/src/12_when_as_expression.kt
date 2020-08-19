fun main() {
    var a = 10

    var str: String = ""

    when (a) {

        // the conditions may be in ranges also
        !in 1..20 -> print("Its greater than 20 or less than 1")

        1 -> print("Its 1")
        2 -> {
            print("Its 2") // these blocks may contain single or multiple line of statement
        }
        3, 4 -> print("Its maybe 3 OR 4") // we can also check the multiple conditions at a time

        1, 2 -> str = "Its 1 or 2" // we can also assign the values to variables when the conditions are executed

        else -> { // this may contain the single statement or multiple statement.
            println("Good bye")
            println("Here the a value is unknown")
        }
    }


    var afterValue : String = when (a) {

        1 -> "Hello"
        2 -> "World"

        else -> {
            "a is awesome"
            "a is 3" // The last statement is assigned to str variable as it is the last statement
        }
    }

    println(afterValue)
}