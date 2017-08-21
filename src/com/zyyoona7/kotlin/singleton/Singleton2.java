package com.zyyoona7.kotlin.singleton;

/**
 * 懒汉式(线程不安全)
 * 懒汉式指的是单例实例在第一次使用时进行创建。
 */
public class Singleton2 {

    private static Singleton2 sInstance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (null == sInstance) {
            sInstance = new Singleton2();
        }
        return sInstance;
    }
}
