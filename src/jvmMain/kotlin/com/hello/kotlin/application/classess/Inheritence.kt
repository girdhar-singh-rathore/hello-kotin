package com.hello.kotlin.application.classess

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 10:23 AM
 */

// inheritance
// class can inherit only one class
// class can implement multiple interfaces
// class can inherit only one class but can implement multiple interfaces
// to extend a class use : after the class name
// open class can be inherited
// by default all the classes are final
// to make a class inheritable use open keyword

class FancyInfoProvider : BasicInfoProvider() {
    override val providerInfo: String
        get() = "FancyInfoProvider"

    override val sessionIdPrefix: String
        get() = "Fancy Session"

    override fun printInfo(customer: Customer) {
        super.printInfo(customer)
        println("fancy info provider")
    }
}


fun main() {
    val provider = FancyInfoProvider()
    provider.printInfo(Customer("john", "doe"))
    println( provider.getSessionId())
}