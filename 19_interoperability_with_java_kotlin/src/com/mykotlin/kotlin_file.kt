// The below line makes the JVM to rename the bytecode file of kotlin to
// mentioned name within the double Inverted Commas
// By default name of byte code file of koltin is Kotlin_fileKt (in this case)

@file: JvmName("kotlin_file_add_function")

package com.mykotlin

import com.myjava.java_file

fun main() {
    var ans = java_file.mult(10, 20)
    println("The answer in Kotlin is $ans")
}

fun add (a: Int, b: Int) : Int {
    return a+b
}