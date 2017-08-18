@file:JvmName("StringUtil")

package com.zyyoona7.kotlin.strings

//顶层函数
@JvmOverloads
fun <T> joinToString(list: Collection<T>, separator: String, prefix: String = "{", postfix: String = "}"): String {
    val strBuilder = StringBuilder(prefix)
    for ((index, value) in list.withIndex()) {
        //第一个元素不加分隔符
        if (index > 0) strBuilder.append(separator)
        strBuilder.append(value)
    }
    strBuilder.append(postfix)
    return strBuilder.toString()
}

//扩展函数
fun String.lastChar(): Char = this[this.length - 1]

@JvmOverloads
fun <T> Collection<T>.collectionToString(separator: String = ",", prefix: String = "[", postfix: String = "]"): String {
    val strBuilder = StringBuilder(prefix)
    for ((index, value) in this.withIndex()) {
        if (index > 0) strBuilder.append(separator)
        strBuilder.append(value)
    }
    strBuilder.append(postfix)
    return strBuilder.toString()
}

//扩展属性，需要定义getter方法，如果是var类型要定义setter方法
val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(char:Char) = setCharAt(length - 1, char)
