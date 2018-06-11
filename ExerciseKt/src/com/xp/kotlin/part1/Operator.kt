package com.xp.kotlin.part1

import java.math.BigDecimal
import java.time.LocalDate

/**
 * @类描述：运算符重载及其他
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/30 0030 16:36
 * @修改人：
 * @修改时间：2018/5/30 0030 16:36
 * @修改备注：
 */
data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Point.minus(other: Point): Point {
    return Point(x - other.x, y - other.y)
}

operator fun Double.times(p: Point): Point {
    return Point((this * p.x).toInt(), (this * p.y).toInt())
}

operator fun Point.times(d: Double): Point {
    return Point((x * d).toInt(), (y * d).toInt())
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun Point.get(index: Int): Int {
    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun operList() {
    val list = arrayListOf(1, 2)
    list += 3
    val newlist = list + listOf(4, 5)
    println(list)
    println(newlist)
}

//operator fun BigDecimal.inc() = this + BigDecimal.ONE

class People(val firstName: String, val lastName: String) : Comparable<People> {
    override fun compareTo(other: People): Int {
        return compareValuesBy(this, other, People::lastName, People::firstName)
    }
}

fun localDate() {
    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)
    println(now.plusDays(1) in vacation)
}

fun valTest() {
    val p = Point(10, 20)
    val (x, y) = p
    println(x)
    println(y)
}

data class NameComponents(val name: String, val extension: String)

fun splitFileName(fullName: String): NameComponents {
    val result = fullName.split(".")
    return NameComponents(result[0], result[1])
}

fun testSplit() {
    val (x, y) = splitFileName("example.kt")
    println(x)
    println(y)
}

fun printEntries(map: Map<String, String>) {//解构的另一种
    for ((k, v) in map) {
        println("$k,$v")
    }
}

class Foo {
    val email by lazy { splitFileName("example.kt") }
}

fun main(args: Array<String>) {
    val p1 = Point(0, 1)
    val p2 = Point(2, 3)
    println(p1 + p2)
    println(Point(0, 1).plus(p2))
    println(1.5 * p2)
    println(p2 * 1.5)
    var point = Point(1, 2)
    point += p1
    println(point)
    operList()
    val p = Point(10, 20)
    println(-p)
    var bd = BigDecimal.ZERO
    println(BigDecimal.ZERO)
    println(bd++)
    println(++bd)
    valTest()
    testSplit()
}
