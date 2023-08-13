package com.hello.kotlin.application.classess.objectdeclarations

import java.util.*

/**
 * @author Girdhar Singh Rathore
 * @date Sunday, August 13, 2023, 11:59 AM
 */

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
        return Entity(id, name)
    }
}

class Entity(val id: String, val name: String) {
    override fun toString(): String {
        return "id: $id name: $name"
    }
}

fun main() {
    val entity = EntityFactory.create(EntityType.EASY)
    println(entity)

    val entity2 = EntityFactory.create(EntityType.HARD)
    println(entity2)
}