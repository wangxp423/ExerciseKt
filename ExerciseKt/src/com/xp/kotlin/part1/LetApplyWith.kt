package com.xp.kotlin.part1

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/6/21 0021 17:23
 * @修改人：
 * @修改时间：2018/6/21 0021 17:23
 * @修改备注：
 */
fun testLet() {
    var data: String? = "abcde"
    val sub = data?.let {
        it.substring(1)
        println(data)
    }
    println(sub)

    val list: MutableList<String> = mutableListOf("A", "B", "C")
    val change = list.let {
        it.add("D")
        it.add("E")
        it.size
    }
    println("list = $list")
    println("change = $change")
}

fun testApply() {
    val data: String? = null
    val result = data?.run {
        this?.substring(2)
//        this?.length
    }
    println(result)
    val build = StringBuilder().apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I konw this alphabet")
        length
    }
    println(build)
}

fun testRun() {
    val data: String? = "12345"
    val result = data?.run {
        this?.substring(2)
//        this?.length
    }
    println(result)
    val list: MutableList<String> = mutableListOf("A", "B", "C")
    val change = list.run {
        add("D")
        add("E")
        this.add("F")
        size
    }
    println("list = $list")
    println("change = $change")
}

fun testWith() {
    val with = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I konw this alphabet")
        toString()
        length
    }
    println(with)

    val list: MutableList<String> = mutableListOf("A", "B", "C")
    val change: Any = with(list) {
        add("D")
        add("E")
        add("F")
        size
    }
    println("list = $list")
    println("change = $change")
}

fun main(args: Array<String>) {
    testLet()
//    testApply()
//    testRun()
//    testWith()
}