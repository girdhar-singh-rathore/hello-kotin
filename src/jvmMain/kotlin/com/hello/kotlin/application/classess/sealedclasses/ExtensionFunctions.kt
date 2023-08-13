package com.hello.kotlin.application.classess.sealedclasses

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 12:38 PM
 */

//extension functions
//extension functions are used to add new functionality to existing class
//extension functions are created outside the class

fun main() {

    val entity = Entity.Medium("id", "name")
    entity.printInfo()
    println(entity.info)

}

//extension function
fun Entity.Medium.printInfo() {
    println("Medium class : $id")
    println("Medium class : $name")

}

//extension property
val Entity.Medium.info: String
    get() = "Medium info"