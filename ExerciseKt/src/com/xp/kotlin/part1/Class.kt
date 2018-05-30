package com.xp.kotlin.part1

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/22 0022 16:53
 * @修改人：
 * @修改时间：2018/5/22 0022 16:53
 * @修改备注：
 */
interface Clickable {
    fun click()
    fun showOff() = println("i'm clickable")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("i'm clickable")
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}

class Button : Clickable, Focusable {
    override fun click() {
        println("i was clicked")
    }

    override fun showOff() {
        super<Clickable>.showOff()
//        super<Focusable>.showOff()
        println("i was clicked implements")
    }
}

open class RichButton : Clickable {
    final override fun click() {} //禁止重写
    fun disable() {}
    open fun animate() {}

}

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Key")
    protected fun whisper() = println("Let's talk")
}

internal fun TalkativeButton.giveSpeech() { //默认是public 会报错
//    yell() //私有不能访问
//    whisper() //只有子类才能访问
}

fun main(agrs: Array<String>) {
    val button = Button()
    button.click()
    button.showOff()
}