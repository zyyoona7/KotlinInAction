package com.zyyoona7.kotlin.singleton

/**
 * 双重检查加锁
 * <p>
 * 使用双重检查加锁，首先进入该方法时进行null == sInstance检查，
 * 如果第一次检查通过，即没有实例创建，则进入synchronized控制的同步块，
 * 并再次检查实例是否创建，如果仍未创建，则创建该实例。
 */
class Singleton4Kt {

    private constructor() {
        println("init Singleton4Kt")
    }

    companion object {
        val instance: Singleton4Kt by lazy {
            Singleton4Kt()
        }
    }
}