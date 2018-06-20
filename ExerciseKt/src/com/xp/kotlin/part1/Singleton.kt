package com.xp.kotlin.part1

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/6/19 0019 17:40
 * @修改人：
 * @修改时间：2018/6/19 0019 17:40
 * @修改备注：
 */
class Singleton private constructor() {
    private object Holder {
        val singleton = Singleton()
    }

    companion object {
        val INSTANCE: Singleton by lazy { Holder.singleton }
        fun getInstance(): Singleton {
            return INSTANCE
        }
    }

    fun getTestString(): String {
        return "shuju"
    }
}

class Singleton1 private constructor(val str: String) {
    companion object {
        var INSTANCE: Singleton1? = null
        fun getInstance(s: String): Singleton1 {
            if (null == INSTANCE) {
                synchronized(Singleton1::class) {
                    if (null == INSTANCE) {
                        INSTANCE = Singleton1(s)
                    }
                }
            }
            return INSTANCE!!
        }
    }

    fun getTestString(): String {
        return str
    }
}

object Singleton2 {
    fun getTestString2(): String {
        return "Singleton2"
    }
}

fun main(args: Array<String>) {
    println(Singleton.getInstance())
    println(Singleton.getInstance())
    println(Singleton.getInstance().getTestString())

    println(Singleton1.getInstance("123"))
    println(Singleton1.getInstance("234"))
    println(Singleton1.getInstance("345").str)

    println(Singleton2)
    println(Singleton2)
    println(Singleton2.getTestString2())
}