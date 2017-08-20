package com.zyyoona7.kotlin

fun main(args: Array<String>) {
    val chapter6 = Chapter6()
    println(chapter6.strLength(null))
    println(chapter6.strLength("123456"))
    val person1 = Person7("zhang", 18)
    val person2 = Person7("zhang", 18)
    println(person1 == person2)
    println(person1.equals(12))

    chapter6.execute(person1)
    chapter6.execute(null)
    //let函数
    val email: String? = "abcde"
    email?.let { chapter6.sendEmail(it) }
    println(chapter6.email)
    val e:String?=null
    e?.let { chapter6.sendEmail(it) }
    if (!e.isNullOrBlank()) {
        chapter6.sendEmail(e!!)
    }
}

class Chapter6 {

    //可空类型
    val str: String? = null
    //延迟初始化
    lateinit var email:String

    //?.运算符，安全调用相当于 if(s!=null) s.length else null
    //?:运算符，null合并运算符 相当于 if(s!=null) s.length else 0
    fun strLength(s: String?): Int {
        return s?.length ?: 0
    }

    private fun isEnable(person: Person7?): Boolean {
        return person != null
    }

    private fun sendAction(person: Person7?) {
        println(person!!.name)
    }

    fun execute(person: Person7?) = if (isEnable(person)) sendAction(person) else println("person is null")

    //let函数
    fun sendEmail(email: String) {
        this.email=email
        println("send an email:$email")
    }

}

class Person7(val name: String, val age: Int) {
    //as? 安全的类型转换
    override fun equals(other: Any?): Boolean {
        val person = other as? Person7 ?: return false

        return this.name == person.name && this.age == person.age
    }

    override fun hashCode(): Int {
        return name.hashCode() * 37 + age.hashCode()
    }
}