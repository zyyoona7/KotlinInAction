package com.zyyoona7.kotlin

fun main(args: Array<String>) {
    val list = listOf(Person("zhang", 21), Person("zhuoyue", 10))
    val maxAge = list.maxBy { p: Person -> p.age }
    val maxAge1 = list.maxBy({ p: Person -> p.age })
    val maxAge2 = list.maxBy { it.age }
    val maxAge3 = list.maxBy(Person::age)
    val maxAge4 = list.maxBy { p -> p.age }
    println("$maxAge,$maxAge1,$maxAge2,$maxAge3,$maxAge4")
}

class Chapter5 {

}

data class Person(val name: String, val age: Int)