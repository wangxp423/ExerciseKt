package com.xp.kotlin.part1

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/7/5 0005 9:50
 * @修改人：
 * @修改时间：2018/7/5 0005 9:50
 * @修改备注：
 */
class LazyLateinit {
    lateinit var name: String
    val nameA: String by lazy { "123" }
}


val nameB: String by lazy {
    println("getLazy")
    "123"
}

fun main(args: Array<String>) {
    println(nameB)
    println(nameB)
}