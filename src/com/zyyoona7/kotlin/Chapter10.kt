package com.zyyoona7.kotlin

import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

fun main(args: Array<String>) {
    val chapter10 = Chapter10()
    val kClass = chapter10::class
    val properties = chapter10.javaClass.kotlin.memberProperties
    kClass.memberProperties.forEach { println(it.name) }
    val jsonName = kClass.memberProperties.filter { it.findAnnotation<JsonName>() != null }
    val prop = jsonName.firstOrNull()

    val clazz = Chapter10::class
    val c1 = clazz.objectInstance ?: clazz.createInstance()
    c1.name = "123"
    c1.printHello()
    println(c1.name)
}

class Chapter10 {
    @JsonName("hello")
    var name: String = "zhang"

    fun printHello() {
        println("Hello!")
    }
}

@Target(AnnotationTarget.PROPERTY,AnnotationTarget.FIELD,AnnotationTarget.VALUE_PARAMETER)
annotation class JsonName(val name: String)