package com.hello.kotlin.application.classess.higherorderfunctions

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 12:43 PM
 */

// higher order functions
// higher order functions are functions that take functions as parameters or return functions
// higher order functions can be used to create 
// APIs
// DSLs
//  lambdas
//  extension functions
//  inline functions
//  anonymous functions
//  local functions
//  nested functions
//  function literals  
//  function types
//  function references
//  function expressions
//  function declarations
//  function invocations
//  function literals with receiver
//  function types with receiver
//  function references with receiver
//  function expressions with receiver

// most of the kotlin library are built using higher order functions
// highly functional code and leverage the power of lambdas

fun main() {
    val list = listOf("Kotlin", "Java", "C++", "JavaScript", "Python", "C#")
    printFilteredString(list) {
        it.startsWith("J")
    }

    printFilteredString(list, null)

    printFilteredString(list, predicate)

    printFilteredString(list, getPrintPredicate())


    list
        .filterNotNull()
        .filter {
            it.startsWith("J")
        }
        .map {
            it.length
        }
        .forEach { println(it) }


}

val predicate: (String) -> Boolean = {
    it.startsWith("J")
}

fun printFilteredString(list: List<String>, predicate: ((String) -> Boolean)?) {

    list.forEach {
        if (predicate?.invoke(it) == true) {
            println(it)
        }
    }
}

fun getPrintPredicate(): (String) -> Boolean {
    return { it.startsWith("J") }
}