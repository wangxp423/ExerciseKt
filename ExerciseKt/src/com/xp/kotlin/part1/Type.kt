package com.xp.kotlin.part1

/**
 * @类描述：类型系统
 * @创建人：Wangxiaopan
 * @创建时间：2018/5/28 0028 16:09
 * @修改人：
 * @修改时间：2018/5/28 0028 16:09
 * @修改备注：
 */
fun strLen(s: String?) = if (s != null) s.length else 0

fun strLen1(s: String?) = s?.length
fun strLen2(s: String?) = s ?: 0
fun foo(s: String?) {
    val t: String = s ?: ""
    println("zifu:" + t)
}

class Employee(val name: String, val manager: Employee?)

fun managerName(imployee: Employee): String? = imployee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class Person1(val name: String, val company: Company?)

fun printShippingLabel(person: Person1) {
    val address = person.company?.address ?: throw IllegalArgumentException("No Address")
    with(address) {
        println(streetAddress)
        println("$zipCode  $city,  $country")
    }
}

class TestType(val firstName: String, val lastName: String) {
    companion object testStatic {
        fun testVoid() {
            println("测试静态方法")
        }
    }
}

object TestStatic {
    fun testStaticVoid() {
        println("测试静态方法1111")
    }
}

fun testEquals(o: Any): Boolean {
    val otherType = o as? TestType ?: return false
    return true
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}


fun main(args: Array<String>) {
    println(strLen(null))
    println(strLen1("123"))
    foo("123")
    val address = Address("Elsestr.47", 80867, "Munich", "Germany")
    val company = Company("JetBrains", address)
    val person = Person1("Dmity", company)
    printShippingLabel(person)
//    printShippingLabel(Person1("Alexey", null))
    println(testEquals("123"))
    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }
    showProgress(20)
    TestType.testVoid()
    TestStatic.testStaticVoid()

}