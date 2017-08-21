package com.zyyoona7.kotlin.singleton;

/**
 * 双重检查加锁
 * <p>
 * 使用双重检查加锁，首先进入该方法时进行null == sInstance检查，
 * 如果第一次检查通过，即没有实例创建，则进入synchronized控制的同步块，
 * 并再次检查实例是否创建，如果仍未创建，则创建该实例。
 */
public class Singleton4 {

    private static volatile Singleton4 sInstance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (null == sInstance) {
            synchronized (Singleton4.class) {
                if (null == sInstance) {
                    sInstance = new Singleton4();
                }
            }
        }
        return sInstance;
    }
}
