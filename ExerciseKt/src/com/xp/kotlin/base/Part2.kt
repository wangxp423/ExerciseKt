package com.xp.kotlin.base

import kotlin.coroutines.experimental.buildSequence

/**
 * Created by Wang on 2017/10/27 0027.
 */
class Address {
    var name: String = "name"
    var street: String = "treet"
    var city: String = "city"
    var state: String = "state"
    var zip: String = "zip"
    fun copyAddress(address: Address): Address {
        val result = Address()
        result.name = address.name
        result.street = address.street
        result.city = address.city
        result.state = address.state
        result.zip = address.zip
        return result
    }
}


fun MutableList<Int>.test(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

open class D {}
class D1 : D() {}
open class C {
    open fun D.foo() {
        println("D.foo in C")
    }

    open fun D1.foo() {
        println("D1.foo in C")
    }

    fun caller(d: D) {
        d.foo()
    }
}

class C1 : C() {
    override fun D.foo() {
        println("D.foo in C1")
    }

    override fun D1.foo() {
        println("D1.foo in C1")
    }
}

val fibonacciSequ = buildSequence {
    var a = 0
    var b = 1
    yield(1)
    while (true) {
        yield(a + b)
        val tmp = a + b
        a = b
        b = tmp
    }
}
val lazySeq = buildSequence {
    print("START ")
    for (i in 1..5) {
        yield(i)
        print("STEP ")
    }
    print("END")
}

val lazySeqAll = buildSequence {
    yield(0)
    yieldAll(1..10)
}

val numberRegex = "\\d+".toRegex()
val isNumber = numberRegex::matches

fun testRegex() {
    println("是否是数字 = " + numberRegex.matches("29"))
    println("是否是 = " + isNumber("29"))
    var list = listOf("qw", "123", "eee")
    println("过滤 = " + list.filter(isNumber))
}

fun main(args: Array<String>) {
//    val address = Address()
//    println("result = " + address.copyAddress(address).name)
//    val l = mutableListOf(1,2,3)
//    l.test(0,2)
//    println("list = $l")
//    C().caller(D())
//    C().caller(D1())
//    C1().caller(D())
//    C1().caller(D1())
    println("序列 = ${fibonacciSequ.take(8).toList()}")
    println("lzay序列 = ${lazySeq.take(8).toList()}")
    lazySeq.take(3).forEach { print("$it") }
    lazySeqAll.forEach { print("$it") }
//    testRegex()
}
