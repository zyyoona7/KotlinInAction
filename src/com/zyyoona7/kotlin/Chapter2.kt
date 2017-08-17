package com.zyyoona7.kotlin

import java.util.*

fun main(args: Array<String>) {
    println("hello world!")
    val chapter = Chapter2()
    chapter.sayHello()
    println(chapter.sayPlus(12, 14))
    println("max=" + chapter.max(1, 5))
    val evalResult = chapter.eval(Sum(Num(3), Num(7)))
    println("when result=$evalResult")
    chapter.cycle1()
    chapter.cycle2()
    chapter.cycle3()
    chapter.cycle4()
    chapter.cycle5()
    chapter.readNumber("abcd")
}

class Chapter2 {

    //变量声明
    //val=value,var=variable
    val a = 12
    val b = ""
    var c: Double = 1.2

    //无返回值方法
    fun sayHello() {
        println("Hello!")
    }

    //带参数有返回值方法
    fun sayPlus(a: Int, b: Int): String {
        return "result=" + (a + b)
    }

    //if else有返回值，相当于java中的三元表达式
    //代码块体函数
    fun max(a: Int, b: Int): Int {
        //Kotlin中if相当于三元表达式，a>b:a?b
        return if (a > b) a else b
    }

    //表达式体 函数
    //如果函数体是由一个表达式构成的，则返回值类型和花括号{}以及return可以省略
    //只有表达式体可以省略返回值类型
    fun max1(a: Int, b: Int) = if (a > b) a else b

    //when
    fun eval(expr: Expr): Int = when (expr) {
        is Num -> expr.num
        is Sum -> eval(expr.left) + eval(expr.right)
        else -> throw Exception("unknown type")

    }

    //for循环
    fun cycle1() {
        //包含1和10
        for (i in 1..10) {
            print("$i ")
        }
        println()
    }

    fun cycle2() {
        //不包含10
        for (i in 1 until 10) {
            print("$i ")
        }
        println()
    }

    fun cycle3() {
        //设置间隔，step 步长
        for (i in 1..10 step 2) {
            print("$i ")
        }

        println()
    }

    fun cycle4() {
        //倒序
        for (i in 10 downTo 1) {
            print("$i ")
        }
        println()
    }

    //遍历map
    fun cycle5() {
        val binaryMap = TreeMap<Char, String>()
        for (char in 'A'..'J') {
            binaryMap[char] = Integer.toBinaryString(char.toInt())
        }

        for ((key, value) in binaryMap) {
            print("$key-$value,")
        }
        println()
    }

    //try -catch
    fun readNumber(str: String) {
        val number = try {
            Integer.parseInt(str)
        } catch (e: NumberFormatException) {
            "not number"
        }
        println(number)
    }
}

interface Expr
class Num(val num: Int) : Expr
class Sum(val left: Num, val right: Num) : Expr