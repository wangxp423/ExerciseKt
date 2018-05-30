package com.xp.kotlin.base

import java.io.File

/**
 * Created by Wang on 2017/10/27 0027.
 */
fun main(args: Array<String>) {
//    print("sum of 3 and 5 is ")
//    println(sum(3, 5))
//    println("sum of 19 and 23 is ${sum1(19, 23)}")
//    printSum(4, 5)
//    printSum1(4, 5)
//    sample()
//    sample1()
//    sampleString()
//    println("max is ${maxof(2, 3)}")
//    println("max1 is ${maxof(3, 2)}")
//    printProduct("6", "7")
//    printProduct("a", "7")
//    printProduct("a", "b")
//    testStringLength("incomparesjfjsklfjl")
//    testStringLength(1000)
//    testStringLength(listOf(Any()))
//    testForeach()
//    testWhile()
//    testWhen()
//    testRange()
//    testForIn()
//    testLambda()
//    testList()
//    testMap()
//    testIsNotNull()
    testEquse()
    testArrayList()
}

//数字
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum1(a: Int, b: Int) = a + b

fun printSum(a: Int, b: Int): Unit {
    println("printSum of $a and $b is ${a + b}")
}

fun printSum1(a: Int, b: Int) {
    println("printSum1 of $a and $b is ${a + b}")
}

//局部变量
fun sample() {
    val a: Int = 1
    val b = 2
    val c: Int
    c = 3
    println("a = $a , b = $b , c = $c")
}

//全局变量
fun sample1() {
    var a = 1
    a += 1
    println("a = $a")
}

//字符串
fun sampleString() {
    var a = 1
    val s1 = "a is $a"
    a = 2
    val s2 = "${s1.replace("is", "was")} but now is $a"
    println("$s2")
}

//if 语句
fun maxof(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxof1(a: Int, b: Int) = if (a > b) a else b

// null 的引用
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    if (x != null && y != null) {
        println(x * y)
    } else {
        println("eigher '$arg1' or '$arg2' is not a number")
    }
}

//is 运算符
fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}

fun testStringLength(obj: Any) {
    println("'$obj' string length is ${getStringLength(obj)} ?: ...erorr,not a string")
}

//for循环
fun testForeach() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

//while循 环
fun testWhile() {
    val items = listOf("apple", "banana", "kiwi")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }
}

//when
fun testWhen(obj: Any): String = when (obj) {
    1 -> "one"
    "hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "not a string"
    else -> "unknown"
}

fun testWhen(str: String): String = when (str) {
    "a" -> "a"
    "b" -> "b"
    "c" -> "c"
    else -> "unknown"
}

fun testWhen() {
    println("${testWhen(1)}")
    println(testWhen("hello"))
    println(testWhen(1000L))
    println(testWhen(2))
    println(testWhen("other"))
    println(testWhen("a"))
    println(testWhen("b"))
    println(testWhen("c"))
}

//range
fun testRange() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in range")
    }
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
    for (x in 1..5) {
        println("x = $x")
    }
    for (x in 1..10 step 2) {
        println("xx = $x")
    }
    for (x in 9 downTo 0 step 4) {
        println("xxx = $x")
    }
}

//in for循环
fun testForIn() {
    val items = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine to")
    }
}

// lambda 表达式
fun testLambda() {
    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println("it = $it") }
}

fun testList() {
    var list = listOf(1, 2, 3, 4)
    val position = list.filter { x -> x > 2 }
    println("position = $position")
}

fun testMap() {
    val map = mapOf("a" to 3, "b" to 2, "c" to 1)
    for ((k, v) in map) {
        println("$k -> $v")
    }
}

fun testIsNotNull() {
    val files = File("Test").listFiles()
//    println(files.size) //报异常
    println(files?.size)
    println(files?.size ?: "empty")
}

fun testEquse() {
    val a: Int = 100
    println(a == a)
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA == anotherBoxedA)
}

fun testArrayList() {
    val strList: Array<String> = arrayOf("0", "1", "4", "9", "16")
    val asc = Array(5, { i -> (i * i).toString() })
    println("asc = ${strList.asList()}")
}