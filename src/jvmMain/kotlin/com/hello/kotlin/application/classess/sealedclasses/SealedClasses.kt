package com.hello.kotlin.application.classess.sealedclasses

import com.hello.kotlin.application.classess.objectdeclarations.EntityType
import java.util.*

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 12:12 PM
 */

// sealed classes
// sealed classes are used to restrict the class hierarchy
// sealed classes are used with when expression
// sealed classes are abstract by default
// sealed classes are not allowed to create instances
// sealed classes are not allowed to have non-private constructors
// sealed classes are allowed to have abstract properties and functions
// sealed classes are allowed to have final properties and functions
// sealed classes are allowed to have private constructors

enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase(Locale.getDefault())
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

object EntityFactory {

    fun create(type: EntityType): Entity {
        val id = UUID.randomUUID().toString()
        val name = when (type) {
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> "Medium"
            EntityType.HARD -> "Hard"
            EntityType.HELP -> "Help"
        }

        return when (type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.HELP -> Entity.Help
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2.0f)
        }
    }
}

// with the sealed classes you can have different properties and functions for each class
// but with enum you can't have different properties and functions for each enum
// sealed classes are used to restrict the class hierarchy
// compiler performs smart casting with sealed classes to allow access to the properties and functions

sealed class Entity() {

    data class Easy(
        val id: String,
        val name: String
    ) : Entity()

    data class Medium(
        val id: String,
        val name: String,
    ) : Entity()

    data class Hard(
        val id: String,
        val name: String,
        val multiplier: Float
    ) : Entity()


    object Help : Entity() {
        val name = "Help"
    }

}

fun main() {
    val entity: Entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val msg = when (entity) {
        Entity.Help -> "Help class"
        is Entity.Easy -> "Easy class"
        is Entity.Medium -> "Medium class"
        is Entity.Hard -> "Hard class"
    }

    println(msg)

}