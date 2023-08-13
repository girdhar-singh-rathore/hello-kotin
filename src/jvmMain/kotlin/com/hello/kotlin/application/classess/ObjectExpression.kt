package com.hello.kotlin.application.classess

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 11:46 AM
 */


fun main() {

    val provider = object : CustomerInfoProvider {
        override val providerInfo: String
            get() = "New Info Provider"
        fun getSessionId() = "NewInfo session"
    }

    provider.printInfo(Customer("john", "doe"))
    println(provider.getSessionId())
}