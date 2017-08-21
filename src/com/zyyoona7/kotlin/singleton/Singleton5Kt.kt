package com.zyyoona7.kotlin.singleton

/**
 * 利用static机制，静态内部类
 * <p>
 * 在Java中，类的静态初始化会在类被加载时触发，我们利用这个原理，
 * 可以实现利用这一特性，结合内部类，可以实现如下的代码，
 * 进行懒汉式创建实例。
 */
class Singleton5Kt {
    private constructor(){
        println("init Singleton5Kt")
    }

    private object Holder {
        val singleton = Singleton5Kt()
    }

    companion object {
        fun getInstance(): Singleton5Kt {
            return Holder.singleton
        }
    }
}