package com.xp.kotlin.part1

/**
 * @类描述：应用常量类
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/21 0021 16:53
 * @修改人：
 * @修改时间：2018/5/21 0021 16:53
 * @修改备注：
 */
interface Expr

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.left) + eval(e.right)
    }
    throw IllegalArgumentException("Unknown expression")
}

fun eval1(e: Expr) =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval(e.left) + eval(e.right)
        } else {
            throw IllegalArgumentException("Unknown expression")
        }

fun eval2(e: Expr) =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.left) + eval(e.right)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun down() {
    for (i in 100 downTo 1 step 3) {
        print("-" + i)
    }
    val list = arrayListOf(10, 22, 100)
    for ((index, element) in list.withIndex()) {
        println()
        print("$index : $element")
    }
}

fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(eval1(Sum(Num(1), Num(2))))
    println(eval2(Sum(Num(3), Num(2))))
    down()
}