package com.zyyoona7.lambda

class ApiDemo private constructor() {

    //双检测单例
    //lazy 默认执行的方法和mode = LazyThreadSafetyMode.SYNCHRONIZED执行相同的方法
    companion object {
        val api: Api by lazy {
            println("api init")
            Api()
        }
    }
}
