package com.zyyoona7.kotlin.singleton;

/**
 * 饿汉式
 * 饿汉式指的是单例的实例在类装载时进行创建。如果单例类的构造方法中没有包含过多的操作处理，饿汉式其实是可以接受的。
 */
public class Singleton1 {
    private static Singleton1 sInstance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return sInstance;
    }
}
