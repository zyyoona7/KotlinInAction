package com.zyyoona7.kotlin

fun main(args: Array<String>) {
    val chapter9 = Chapter9()
    val list = listOf(1, 2, 3, 4, 5)
    chapter9.printClass(list)
    val cat = Animal(Cat("喵喵"))
    println(cat)
}

class Chapter9 {

    //泛型函数
    fun <T : Any> printClass(t: T) {
        println(t.toString())
    }
}

//泛型类
//out关键字协变 对应java<? extends T>，只允许T作为返回值类型，不可作为参数，属于生产者只能读取
//in关键字逆变 对应java <? super T>，只允许T作为参数，属于消费者只能写入不能读取
class Animal<out T>(val animal: T) {

    override fun toString(): String {
        return animal.toString()
    }
}

data class Cat(val name: String)