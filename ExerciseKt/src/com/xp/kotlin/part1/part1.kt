package com.xp.kotlin.part1

/**
 * Created by Wang on 2017/10/27 0027.
 */
data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons = listOf(Person("Alice"), Person("Bob", age = 29))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is: $oldest")
    println("a > b = " + max(1, 2))
    println("Hello,${if (args.size > 0) args[0] else "someone "}")
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

