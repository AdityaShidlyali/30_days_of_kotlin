/*
* List in Kotlin are immutable that is read only and they are fixed size.
*
* Syntax to define the List in Kotlin is :
* var/val listName: List<Type> = listOf<Type>(elements_of_type_Type)
*
* In Kotlin the ArrayList are referred as the mutableList
* these mutable list are not fixed in size and mutable in nature.
*
* syntax to define the ArrayList aka mutableList is :
* var/val mutableListName: MutableList<Type> = mutableListOf<Type>()
*
* we can also use the ArrayList in Kotlin.
* mutableListOf and ArrayList work both similar and all the methods of the mutableListOf are implemented using the ArrayList
* */

fun main() {
    var list: List<Int> = listOf<Int>(1, 2, 3, 4, 5, 6, 7)

    // one way of printing the list
    for (i in list) {
        print("$i ")
    }

    println()

    // another way of printing the list in Koltin
    for (i in 0..list.size - 1) {
        print("${list[i]} ")
    }

    // Mutable list (ArrayList)
    var mutableList: MutableList<Int> = mutableListOf<Int>()

    // To add the elements at the end of the list
    mutableList.add(10)
    mutableList.add(20)
    mutableList.add(30)

    // remove the element from the list using specific value
    mutableList.remove(20)

    // add element at the specific index
    mutableList.add(2, 100)

    // we can replace elements in array list using [] operator
    mutableList[1] = 200

    // we can also define the ArrayList instead of mutableListOf
    var myArrayList: ArrayList<Int> = ArrayList<Int>(10)
}