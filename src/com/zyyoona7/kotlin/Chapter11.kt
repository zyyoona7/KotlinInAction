package com.zyyoona7.kotlin

fun main(args: Array<String>) {
    val str1 = buildString {
        it.append("Hello ")
        it.append("World")
        it.append("!")
    }
    println(str1)

    val str2 = buildString1 {
        append("Hello ")
        append("lambda")
    }

    println(str2)

    val str3 = buildString2 {
        println(it)
        append("你 ")
        append("好")
    }
    println(str3)

    val today=3.days.fromNow
    println(today)
}

fun buildString(buildAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    buildAction(sb)
    return sb.toString()
}

//带接受者的lambda
fun buildString1(buildAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
    sb.buildAction()
    return sb.toString()
}

fun buildString2(buildAction: StringBuilder.(String) -> Unit): String {
    return StringBuilder().apply { buildAction("Hi!") }.toString()
}

class Chapter11 {

}