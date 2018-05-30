package com.xp.kotlin.part1

/**
 * @类描述：lambda表达式
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/24 0024 18:09
 * @修改人：
 * @修改时间：2018/5/24 0024 18:09
 * @修改备注：
 */
val sum = { x: Int, y: Int -> x + y }

fun printMessagePrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix : $it")
    }
}

data class TPerson(val name: String, val age: Int)

val createPerson = ::TPerson
val p = createPerson("wangxp", 28)
val personAgeFunction = TPerson::age
val dmitrysAgeFunction = p::age
val people = listOf(TPerson("Alice", 27), TPerson("Bob", 31), TPerson("Carol", 31))
val canBeInClub27 = { p: TPerson -> p.age <= 27 }

val naturalNumbers = generateSequence(0) { it + 1 }
val numbersTo100 = naturalNumbers.takeWhile { it <= 10 }
fun alphabet() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I konw this alphabet")
    toString()
}

fun alphabet1() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I konw this alphabet")
}.toString()

fun main(args: Array<String>) {
    println(sum(1, 2))
    val messages = listOf("403 Forbidden", "404 Forbidden")
    printMessagePrefix(messages, "Error")
    println(p)
    println(personAgeFunction(p))
    println(dmitrysAgeFunction())
    println(people.map { it.age })
    println(people.map(TPerson::age))
    println(people.filter { it.age > 30 }.map(TPerson::age))
    people.filter { it.age == people.maxBy { it.age }!!.age }
    val maxAge = people.maxBy(TPerson::age)!!.age
    println(people.filter { it.age == maxAge })
    println(canBeInClub27)
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))
    println(people.filter(canBeInClub27).size)
    println(people.groupBy { it.age })
    println(numbersTo100.sum())
}