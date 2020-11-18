/*
* The data class in the Kotlin are made to deal with only the data of the class and not with object (irrespective of the object).
* we can also override the data inside the data class with different objects.
*
* The data class can do the work for the following things:
* 1. Every class need "toString" method to get the parameters of the constructor to return for the caller
* 2. equals and hashcode - to compare the content of two methods are equal or not
* 3. copy - to deepcopy the objects
* Note: The constructor of the data class must contain only the propertied parameters(i.e. var or val).
* */

fun main() {

    // The below objects are considered to be two different resources in case normal classes, if they are compared they give false result
    // And in the case of the data classes when these are compared they give true result. if the data both the objects are same.
    val o1 = Base("Aditya", 10)
    val o2 = Base("Aditya", 10)

    if (o1 == o2) {
        println("They are equal")
    } else {
        println("They are not equal")
    }

    // The following statement prints the address of the instance when there is normal class.
    // If the class is data class it shows the information about the ClassName and parameters which are to be passed.
    println(o1)
    // The below function prints the same result as toString is provided by the 'Any' class which is super class in Kotlin.
    println()

    // Below function (copy()) creates copy of the object with the data too, and it is provided by the 'Any' class which is super class in Kotlin.
    // the copy function can only be accessed for data classes and not for normal classes
    val o3 = o1.copy()
    if (o3 == o1) {
        println("The are equal")
    } else {
        println("They are not equal")
    }

    // We can also override the data which is already there in the data class.
    // We can override all the properties or we can do it selectively.
    val o4 = o1.copy(name = "Aditya 2")
}

// In the data class the parameters in the primary constructor, there should be only propertied parameters. (i.e. val or var)
data class Base(var name: String, var id: Int) {

}