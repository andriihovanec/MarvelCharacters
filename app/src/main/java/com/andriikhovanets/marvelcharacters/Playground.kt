package com.andriikhovanets.marvelcharacters

import kotlin.reflect.KProperty

class Playground

fun main() {
    val user = User(mapOf(
        "name" to "John Doe",
        "age" to 25
    ))
    val example = Example()
    println(example.p)
    example.p = "NEW"
}

class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

class Delegate: ReadWriteProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return "$thisRef, спасибо за делегирование мне '${property.name}'!"
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("$value было присвоено значению '${property.name} в $thisRef.'")
    }

    //without interface
    /*operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, спасибо за делегирование мне '${property.name}'!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value было присвоено значению '${property.name} в $thisRef.'")
    }*/
}

interface ReadOnlyProperty<in R, out T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
}

interface ReadWriteProperty<in R, T> {
    operator fun getValue(thisRef: R, property: KProperty<*>): T
    operator fun setValue(thisRef: R, property: KProperty<*>, value: T)
}

class Example {
    var p: String by Delegate()
}