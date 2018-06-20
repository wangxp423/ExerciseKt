package com.xp.kotlin.part1

import kotlin.reflect.KProperty

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/6/19 0019 15:57
 * @修改人：
 * @修改时间：2018/6/19 0019 15:57
 * @修改备注：
 */
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class Example {
    val d = Delegate()
    val e = Delegate()
    var p: String by d
    var l: String by e
}

fun main(args: Array<String>) {
    val e = Example()
    println(e.p)
    e.p = "NEW"
    println(e.l)
    e.l = "NEW.L"
    println(e.d)
    println(e.e)
}