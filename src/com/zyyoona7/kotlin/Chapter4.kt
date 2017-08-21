package com.zyyoona7.kotlin

fun main(args: Array<String>) {
    val subBtn = SubButton()
    subBtn.click()
    subBtn.showOff()
    subBtn.setFocusable(false)
    subBtn.setClickable(true)

    val p1 = Person6("zhang", 20)
    val p2 = Person6("zhang", 20)

    println(p1 == p2)

    val set = CountingSet<Int>()
    set.add(1)
    set.addAll(hashSetOf(1, 2, 3))
    println(set.counter)
    //对象表达式
    val listener = object : OnClickListener {
        override fun onClick() {
        }
    }

}

const val KEY_1:Int=1

class Chapter4 {

}

interface OnClickListener {
    fun onClick()
}

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable")
}

interface Focusable {
    fun setFocusable(isFocus: Boolean)
    fun showOff() = println("I'm focusable")
}

abstract class Button : Clickable, Focusable {
    override fun showOff() {
        super<Clickable>.showOff()
    }

    final override fun setFocusable(isFocus: Boolean) {
        println("I'm ${if (isFocus) "got" else "lose"} focus")
    }

    override fun click() {
        println("Button click")
    }

    abstract fun setClickable(isClickable: Boolean)

}

class SubButton : Button() {
    final override fun setClickable(isClickable: Boolean) {
        println("I'm ${if (isClickable) "" else "not"} clickable")
    }

    final override fun click() {
        println("SubButton Click")
    }
}

//一个完整构造方法的形式
class Person1 constructor(_nickName: String) {
    val nickName: String

    init {
        nickName = _nickName
    }
}

class Person2 constructor(_nickName: String) {
    val nickName = _nickName
}

class Person3(val nickName: String)

class Person4 private constructor(val nickName: String)

class Person5() {
    var nickName = ""
        private set
}

//data类，自动生成hashCode,equals,toString方法
data class Person6(val name: String, val age: Int)

//委托
class CountingSet<T>(val set: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by set {

    var counter = 0

    override fun add(element: T): Boolean {
        counter++
        return set.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        counter += elements.size
        return set.addAll(elements)
    }
}