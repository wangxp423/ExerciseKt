package com.xp.kotlin.part1

import java.io.Serializable

/**
 * @类描述：内部类 嵌套类
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/22 0022 18:23
 * @修改人：
 * @修改时间：2018/5/22 0022 18:23
 * @修改备注：
 */
interface State : Serializable {}

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

class Button1 : View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {}
    class ButtonState : State {}
}

class Outer {
    inner class Inner {
        val outer = this@Outer
        fun getOuterReference(): Outer = outer
    }
}

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>()) : MutableCollection<T> by innerSet {
    var add = 0
    override fun add(element: T): Boolean {
        add++
        return innerSet.add(element)
    }
}


