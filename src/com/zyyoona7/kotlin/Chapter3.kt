package com.zyyoona7.kotlin

import com.zyyoona7.kotlin.strings.lastChar as last
import com.zyyoona7.kotlin.strings.*
import com.zyyoona7.kotlin.strings.lastChar

fun main(args: Array<String>) {
    val chapter3 = Chapter3()
    val list = listOf(1, 2, 3, 4, 5)
    //命名参数调用
//    val result=chapter3.joinToString(list,separator = "<")
//    println(result)
    //顶层函数
    val result = joinToString(list, separator = ":")
    println(result)
    //扩展函数
    println("Kotlin".last())
    val str = list.collectionToString()
    println(str)
    //扩展属性
    println("Happy".lastChar)
    val sb = StringBuilder("Happy")
    sb.lastChar = 'a'
    println(sb)
    val user = User(1, "zhang", "haha")
    chapter3.saveUser(user)
}

class Chapter3 {


    //命名参数，默认参数
    //@JvmOverloads可以在java的调用中按照默认参数生成对应的重载方法
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

    //局部函数
    fun saveUser(user: User) {
//        fun validate(value: String, field: String) {
//            if (value.isEmpty()) {
//                throw IllegalArgumentException("can not save ${user.id}: empty $field")
//            }
//        }
//        user.validate(user.name, "Name")
//        user.validate(user.address, "Address")
        user.validateBeforeSaved()
        println("user saved!")
    }

    private fun User.validateBeforeSaved() {
        fun validate(value: String, field: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("can not save $id: empty $field")
            }
        }
        validate(name, "Name")
        validate(address, "Address")
        KEY_1
    }
}

class User(val id: Int, val name: String, val address: String)