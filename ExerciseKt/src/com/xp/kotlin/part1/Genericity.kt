package com.xp.kotlin.part1

/**
 * @类描述：泛型
 * @创建人：Wangxiaopan
 * @创建时间：2018/6/7 0007 15:30
 * @修改人：
 * @修改时间：2018/6/7 0007 15:30
 * @修改备注：
 */
val authors = listOf("Dmitry", "Svetlana")
val readers = mutableListOf("Xiaopan", "Xiaoer")
val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')) {
        seq.append('.')
    }
}

//fun <T> isA(value: Any) = value is T //会报错cannot check
//但是内联函数却不会，因为如果用inline关键字标记一个函数，编译器会把每一次函数调用都转换成
//函数实际的代码实现
//编译器把实现内联函数的字节码插入到每一次调用发生的地方，每次你调用带实化类型参数的函数，编译器都知道这次特定调用中用作类型实参的确切类型
inline fun <reified T> isA(value: Any) = value is T

val items = listOf("one", 2, "three")

open class Animal {
    fun feed() {
        println("feed")
    }
}

class Cat : Animal() {
    fun cleanLitter() {
        println("cleanLitter")
    }
}

class Herd<T : Animal>(t: T) {
    var test: T = t
    fun getHerd(): T {
        return test
    }
}

fun feedAll(animals: Herd<Animal>) {
    animals.getHerd().feed()
}

fun takeCareOfCate(cat: Herd<Cat>) {
//    feedAll(cat)
}

fun <T : R, R> copyData(source: MutableList<T>, destination: MutableList<R>) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T> copyData1(source: MutableList<out T>, destination: MutableList<T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T> copyData2(source: MutableList<T>, destination: MutableList<in T>) {
    for (item in source) {
        destination.add(item)
    }
}

fun testInOut() {
    val list: MutableList<out Number> = mutableListOf(1, 2, 3, 4)
    println(list)
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
    copyData(ints, anyItems)
    copyData1(ints, anyItems)
    copyData1(list, anyItems)
    copyData2(ints, anyItems)
    println(anyItems)
}

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String): Boolean {
        return input.isNotEmpty()
    }
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int): Boolean {
        return input >= 0
    }
}

fun main(args: Array<String>) {
    println(listOf(1, 2, 3, 4).penultimate)
    val helloworld = StringBuilder("hello world")
    ensureTrailingPeriod(helloworld)
    println(helloworld)
    println(isA<String>("abc"))
    println(isA<String>(123))
    println(items.filterIsInstance<String>())//类型实参在运行时是已知的。
    testInOut()
}