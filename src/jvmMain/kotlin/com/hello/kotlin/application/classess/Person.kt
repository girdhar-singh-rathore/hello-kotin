package com.hello.kotlin.application.classess

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 9:26 AM
 */
class Person {
}

class Person3() {}

class Person2 constructor()

class Person4 constructor(firstName: String, lastName: String)

class Person5(firstName: String, lastName: String) {
    val firstName: String
    val lastName: String

    init {
        this.firstName = firstName
        this.lastName = lastName
    }
}

class Person6(firstName: String, lastName: String) {
    val firstName: String = firstName
    val lastName: String = lastName
}

class Person7(val firstName: String, val lastName: String)

//secondary constructor
class Person8(val firstName: String, val lastName: String) {
    init {
        println("init block of primary constructor")
    }

    constructor() : this("Hello", "Kotlin, Secondary Constructor")

    //init block always execute before secondary constructor
    init {
        println("init block of secondary constructor")
    }
}

//default values at primary constructor
class Person9(val firstName: String = "Hello", val lastName: String = "Kotlin")


// by default val generate getter and setter, override the default getter and setter

class Person10(val firstName: String, val lastName: String) {
    internal var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value")
        }
        get() {
            println("the returned value is $field")
            return field
        }

    fun printInfo() {
        //elvis operator ?:
        //if nickName is null then print "no nickname" else print nickName
        val nickNameToPrint = nickName ?: "no nickname"
        println("$firstName ($nickNameToPrint) $lastName")
    }
}




fun main() {
    println("Classes")

    val person = Person6("Hello", "Kotlin")
    println(person)

    println("access the properties of class")
    println("${person.firstName} ${person.lastName}")

    println("Secondary constructor")
    val person8 = Person8()
    println("${person8.firstName} ${person8.lastName}")

    println("default values at primay constructor")
    val person9 = Person9()
    println("${person9.firstName} ${person9.lastName}")

    println("override the default getter and setter")
    val person10 = Person10("Hello", "Kotlin")
    person10.printInfo()
    println("${person10.firstName} ${person10.lastName}")
    person10.nickName = "Nick"
    println("${person10.nickName}")
    person10.printInfo()
}