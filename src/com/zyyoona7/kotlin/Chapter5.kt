package com.zyyoona7.kotlin

fun main(args: Array<String>) {
    val list = listOf(Person("zhang", 21), Person("zhuoyue", 10))
    val maxAge = list.maxBy { p: Person -> p.age }
    val maxAge1 = list.maxBy({ p: Person -> p.age })
    val maxAge2 = list.maxBy { it.age }
    val maxAge3 = list.maxBy(Person::age)
    val maxAge4 = list.maxBy { p -> p.age }
    println("$maxAge,$maxAge1,$maxAge2,$maxAge3,$maxAge4")


    val chapter5 = Chapter5()
    println(chapter5.alphabet1())
    println(chapter5.alphabet2())
    println(chapter5.alphabet3())
}

class Chapter5 {

    //with，apply
    fun alphabet1(): String {
        val strBuilder = StringBuilder()
        for (str in 'A'..'Z') {
            strBuilder.append(str)
        }
        strBuilder.append("\nalphabet1 print finished.")
        return strBuilder.toString()
    }


    fun alphabet2():String {
        val strBuilder = StringBuilder()
        return with(strBuilder) {
            for (str in 'A'..'Z') {
                append(str)
            }
            append("\nalphabet2 print finished.")
            toString()
        }
    }

    fun alphabet3() = StringBuilder().apply {
        for (str in 'A'..'Z') {
            append(str)
        }
        append("\nalphabet3 print finished.")
    }.toString()
}

data class Person(val name: String, val age: Int)