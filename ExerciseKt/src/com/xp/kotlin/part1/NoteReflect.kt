package com.xp.kotlin.part1

import kotlin.reflect.full.memberProperties

/**
 * @类描述：注解和反射
 * @创建人：Wangxiaopan
 * @创建时间：2018/6/8 0008 16:41
 * @修改人：
 * @修改时间：2018/6/8 0008 16:41
 * @修改备注：
 */
data class PersonN(val name: String, val age: Int)

fun foo1(x: Int) = println(x)

fun testKclass() {
    val person = PersonN("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }
    val kFunction = ::foo1
    kFunction.call(32)
}

fun main(args: Array<String>) {
    testKclass()
}