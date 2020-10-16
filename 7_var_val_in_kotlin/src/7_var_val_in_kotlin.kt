fun main(args: Array<String>) {

    // Syntax to define the variables are of two types
    // 1. var or val variable_name : datatype = value
    // 2. var or val variable_name = value

    // in the below case both  are accepted, because the kotlin compiler automatically recognises the datatype of the variable
    var age1: Int = 10
    var age2 = 10

    // Note that the datatypes start with the capital letters
    // as all the datatypes are "Objects"

    // Note that the Kotlin has no primitive datatypes

    /*
    * Various Datatypes in Kotlin are :
    * 1. Boolean  --  1 Bit
    * 2. Byte     --  8 Bit
    * 3. Char     --  16 Bit
    * 4. Short    --  16 Bit
    * 5. Int      --  32 Bit
    * 6. Long     --  64 Bit
    * 7. Float    --  32 Bit
    * 8. Double   --  64 Bit
    * */

    /*
    * Difference Between var and val
    * 1.var is Mutable      |  1. val is Immutable
    * 2.using var the value |  2.using val the value
    * variable cannot be    |  of the variable can be
    * changed               |  changed
    * */

    // Following statements are the demo on datatypes
    var isTrue: Boolean = true
    var byteValue: Byte = 20
    var charValue: Char = 'A'
    var shortValue: Short = 123
    var intValue: Int = 65000
    var longValue: Long = 123456L // L or l
    var floatValue: Float = 3.142F // F or f
    var doubleValue: Double = 123.14123
}