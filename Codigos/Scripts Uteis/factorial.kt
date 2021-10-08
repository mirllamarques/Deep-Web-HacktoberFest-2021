/**
 * Kotlin factorial with recursion 
 */

fun factorial(number : Int) : Long {
    
    if(number == 0){
        return 1
    }
    
    return number * factorial(number - 1)
}