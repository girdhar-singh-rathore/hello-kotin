package com.hello.kotlin.application.classess

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 10:04 AM
 */

// Visibility Modifiers
// public, private, protected, internal
//visibility modifiers
//public: default visibility modifier
//internal: visible inside the module, public inside the module
//private: visible inside the file, public inside the file
//protected: visible inside the class or subclass
//same goes for the properties and functions


//marker interface
//marker interface don't have any method or property but it is used to mark the class as something special
//eg: Serializable, Cloneable, Comparable
interface PersonInfoProvider


interface CustomerInfoProvider {
    val providerInfo: String
    fun printInfo(customer: Customer) {
        println(providerInfo)
        customer.printInfo()
    }
}

interface SessionInfoProvide {
    fun getSessionId(): String
}

open class BasicInfoProvider : CustomerInfoProvider, SessionInfoProvide {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    protected open val sessionIdPrefix = "Session"

    override fun printInfo(customer: Customer) {
        println("the basic info provider, print info")
        super.printInfo(customer)
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}


class Customer(private val firstName: String, private val lastName: String) {
    private var fullName: String = "$firstName $lastName"
    protected var nickName: String? = null
        set(value) {
            field = value
            println("the new nickname is $value")
        }
        get() {
            println("the returned value is $field")
            return field
        }

    fun printInfo() {
        println("the full name is $fullName")
    }
}

fun main() {
    println("Visibility Modifiers")
    val provider = BasicInfoProvider()
    provider.printInfo(Customer("john", "doe"))
    provider.getSessionId()

    //type casting
    checkTypes(provider)
}

fun checkTypes(infoProvider: CustomerInfoProvider) {

    // use is or !is
    if (infoProvider is SessionInfoProvide) {
        println("session info provider")
        // use as to cast
        //explicitly casting
        println((infoProvider as SessionInfoProvide).getSessionId())
        println( infoProvider.getSessionId())
    } else {
        println("not session info provider")
    }

}