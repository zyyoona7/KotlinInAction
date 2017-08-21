package com.zyyoona7.kotlin.singleton;

/**
 * synchronized修饰方法(性能差)
 * 使用synchronized修饰getInstance方法可能是最简单的一个保证多线程保证单例唯一性的方法。
 * synchronized修饰的方法后，当某个线程进入调用这个方法，该线程只有当其他线程离开当前方法后才会进入该方法。
 * 所以可以保证getInstance在任何时候只有一个线程进入。
 */
public class Singleton3 {

    private static Singleton3 sInstance;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (null == sInstance) {
            sInstance = new Singleton3();
        }
        return sInstance;
    }
}
