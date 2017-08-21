package com.zyyoona7.kotlin

import com.zyyoona7.kotlin.singleton.Singleton3Kt
import com.zyyoona7.kotlin.singleton.Singleton4Kt


fun main(args: Array<String>) {
    val p1 = Point(1, 2)
    val p2 = Point(2, 3)
    println(p1 + p2)

    val list = arrayListOf(1, 2, 3, 4)
    list += 5
    println(list)

    val point = Point(10, 20)
    println(-point)

    println(p1 == p2)

    println(p1[0])
    val mutablePoint = MutablePoint(1, 2)
    mutablePoint[0] = 10
    println(mutablePoint)

    val chapter7 = Chapter7()
    chapter7.prop
    chapter7.prop

    Singleton3Kt.getInstance()
}

class Chapter7 {

    //委托属性，惰性加载默认线程安全
    val prop: Int by lazy {
        println("init prop")
        12
    }

    //指定线程mode
    val prop1: Int by lazy(mode = LazyThreadSafetyMode.NONE) {
        println("init prop1")
        123
    }
}

//重载二元运算符
operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

//重载复合赋值运算符
//public inline operator fun <T> MutableCollection<in T>.plusAssign(element: T) {
//    this.add(element)
//}
//重载一元运算符
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

//重载比较运算符

//重载下标运算符
operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("invalid coordinate $index")
    }
}

operator fun MutablePoint.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("invalid coordinate $index")
    }
}

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("invalid coordinate $index")
    }
}

data class Point(val x: Int, val y: Int)

data class MutablePoint(var x: Int, var y: Int)