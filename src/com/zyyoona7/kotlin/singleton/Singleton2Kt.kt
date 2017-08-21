package com.zyyoona7.kotlin.singleton

/**
 * 懒汉式(线程不安全)
 * 懒汉式指的是单例实例在第一次使用时进行创建。
 */
class Singleton2Kt {

    private constructor(){
        println("init Singleton2Kt")
    }

    companion object {
        val instance: Singleton2Kt by lazy(mode = LazyThreadSafetyMode.NONE) {
            Singleton2Kt()
        }
    }
}