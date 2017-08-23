package com.zyyoona7.kotlin

import java.util.concurrent.locks.Lock

fun main(args: Array<String>) {
    val view = View()
    val view1: View? = View()
    view.mockOnClick(view)
    view.setOnClickListener { println(view) }
    view.mockOnClick(view)
    view.mockOnClick(view)
    view.addListener { onClick() }

    val chapter8 = Chapter8()
    val calculator = chapter8.getShippingCostCalculator(Delivery.EXPEDITED)
    println(calculator(Order(5)))
}

class Chapter8 {

    //返回函数的函数
    fun getShippingCostCalculator(delivery: Delivery): ((Order) -> Double) {
        if (delivery == Delivery.EXPEDITED) {
            return { order -> 6 + 2.1 * order.itemCount }
        }

        return { order -> 1.2 * order.itemCount }
    }

    //内联函数
    inline fun <T> synchronized(lock: Lock, action: () -> T): T {
        lock.lock()
        try {
            return action()
        } finally {
            lock.unlock()
        }
    }
}

fun View.addListener(init:View.() -> Unit) {
    View().apply(init)
}

class View {

    //使用高阶函数定义回调
    var listener: ((view: View) -> Unit)? = null

    fun setOnClickListener(listener: ((view: View) -> Unit)?) {
        println("setOnClickListener")
        this.listener = listener
    }

    fun mockOnClick(view: View) {
        listener?.let {
            listener!!(view)
        }
    }

    fun onClick() {

    }

    fun onTouch() {

    }

}

enum class Delivery {STANDARD, EXPEDITED }

class Order(val itemCount: Int)