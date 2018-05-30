package com.xp.kotlin.part1

/**
 * @类描述：集合
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/22 0022 11:32
 * @修改人：
 * @修改时间：2018/5/22 0022 11:32
 * @修改备注：
 */
val list = listOf(1, 2, 3)
var strings: List<String> = listOf("first", "second", "fourtenth")
var map = mapOf(1 to "one", 2 to "two", 3 to "three")

infix fun Any.to(other: Any) = Pair(this, other)

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("can't save user ${user.id}:  empty $fieldName")
        }
    }
    validate(user.name, "Name")//局部函数进行验证
}

fun User.validateBeforeSave() {
    //用扩展函数进行验证
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("can't save user $id:  empty $fieldName")
        }
    }
    validate(name, "Name")
}

fun saveUser1(user: User) {
    user.validateBeforeSave()
}

fun main(args: Array<String>) {
    println(list)
    println(strings.last())
    var mList = listOf("args", *args)//*被称为展开运算符
    println(mList)
    println(map)
    for ((index, element) in strings.withIndex()) {
        println("$index = $element")
    }
    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))
}