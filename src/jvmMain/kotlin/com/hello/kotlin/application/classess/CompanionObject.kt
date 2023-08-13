package com.hello.kotlin.application.classess

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 11:50 AM
 */

// companion object
// companion object is same as static in java
// companion object is used to create static methods and variables
// companion object is created inside the class
// companion object is created using companion keyword

interface IdProvider {
    fun getId(): String
}

class Entity private constructor(val id: String) {

    companion object : IdProvider {
        fun create() = Entity(getId())
        const val ID = "id"
        override fun getId(): String {
            return "123"
        }
    }
}


fun main() {
    val entity = Entity.create()
    println(entity.id)
    println(Entity.getId())
}