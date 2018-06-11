package com.xp.kotlin.part1

/**
 * @类描述：高阶函数：lambda作为形参和返回值
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/31 0031 18:12
 * @修改人：
 * @修改时间：2018/5/31 0031 18:12
 * @修改备注：
 */
val sum1 = { x: Int, y: Int -> x + y }

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}

enum class Delivery { STANDARD, KXPEDITED }
class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.KXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}

class ContactListFilters {
    var prefix: String = ""
    val onlyWithPhoneNumber: Boolean = false
}

data class SiteVisit(val path: String, val duration: Double, val os: String)

val log = listOf(SiteVisit("/", 34.0, "WINDOWS"),
        SiteVisit("/", 22.0, "MAC"),
        SiteVisit("/login", 12.0, "WINDOWS"),
        SiteVisit("/signup", 8.0, "IOS"),
        SiteVisit("/", 16.3, "ANDROID"),
        SiteVisit("/", 16.3, "MAC"))

val averageWindowsDuration = log.filter { it.os == "WINDOWS" }.map(SiteVisit::duration).average()
val averageWindowsDurationTwo = log.filter { it.os in setOf("WINDOWS", "MAC") }.map(SiteVisit::duration).average()

fun List<SiteVisit>.averageDurationFor(os: String) = filter { it.os == os }.map(SiteVisit::duration).average()

fun lookforMac(list: List<SiteVisit>) {
    list.forEach {
        if (it.os == "MAC") {
            println("Found!")
            return
        }
    }
    println("MAC is not Found!")
}

fun lookforMacLabel(list: List<SiteVisit>) {
    list.forEach label@{ if (it.os == "MAC") return@label }
    println("MAC might be somewhere")
}

//1和2一样
fun lookforMacLabe2(list: List<SiteVisit>) {
    list.forEach { if (it.os == "MAC") return@forEach }
    println("MAC might be somewhere")
}

//2和3的返回位置一样
fun lookforMac3(list: List<SiteVisit>) {
    list.forEach(fun(sitevisit) {
        if ("MAC" == sitevisit.os) return
    })
    println("MAC might be somewhere")
}

val filterMac = log.filter(fun(sitevisit): Boolean {
    return "MAC" == sitevisit.os
})

fun main(args: Array<String>) {
    twoAndThree(sum1)
    twoAndThree { x, y -> x + y }
    twoAndThree { x, y -> x - y }
    println("ab1c".filter { it in 'a'..'z' })
    processTheAnswer { x -> x + 1 }
    val calculator = getShippingCostCalculator(Delivery.KXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")
    println(averageWindowsDuration)
    println(averageWindowsDurationTwo)
    println(log.averageDurationFor("MAC"))
    lookforMac(log)
    lookforMacLabel(log)
    lookforMac3(log)
    println(filterMac)
}