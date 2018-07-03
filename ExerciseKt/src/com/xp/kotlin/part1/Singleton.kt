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

class Singleton3 {
    companion object Factory : CallBackListener {
        override fun requestSuccess() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun requestFail() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        fun getTestString3(): String {
            return "Singleton3"
        }
    }
}

class Singleton4 {}

interface CallBackListener {
    fun requestSuccess()
    fun requestFail()
}

class AddCallBackListener {
    fun addListener(listener: CallBackListener) {}
}

object DefaultListener : CallBackListener {
    override fun requestSuccess() {
        println("requestSuccess")
    }

    override fun requestFail() {
        println("requestFail")
    }
}

class TestOkc {
    private fun okc() = object {
        val x: String = "x"
    }

    fun okcT() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = okc().x
//        val x2 = okcT().x
    }
}

fun countClicks(add: AddCallBackListener) {
    var clickCount = 0
    add.addListener(object : CallBackListener {
        override fun requestSuccess() {
            clickCount++
        }

        override fun requestFail() {
            clickCount--
        }
    })
}


open class A(x: Int) {
    public open val y: Int = x
}

interface B {}

val ab: A = object : A(1), B {
    override val y: Int
        get() = 15
}

fun TestObject() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    println(adHoc.x + adHoc.y)
}

fun main(args: Array<String>) {
    println(Singleton)
    println(Singleton.getInstance())
    println(Singleton.getInstance())
    println(Singleton.getInstance().getTestString())
    println("----------------------------------")
    println(Singleton1)
    println(Singleton1.getInstance("123"))
    println(Singleton1.getInstance("234"))
    println(Singleton1.getInstance("345").str)
    println("----------------------------------")
    println(Singleton2)
    println(Singleton2)
    println(Singleton2.getTestString2())
    println("----------------------------------")
    println(Singleton3)
    println(Singleton3)
    println(Singleton3.getTestString3())
    println("----------------------------------")
    println(DefaultListener)
    println(DefaultListener)
    println(DefaultListener.requestSuccess())
    println("----------------------------------")
    println(ab.y)

    val add = AddCallBackListener()
    add.addListener(object : CallBackListener {
        override fun requestSuccess() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun requestFail() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    })
}