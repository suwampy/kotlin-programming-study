package com.chap02.section2

fun main() {
    var a = 1
    var str1 = "a = $"
    // 문자열에 표현식 사용하기
    var str2 = "a = ${a + 2}"

    // 형식화된 다중 문자열 사용하기
    val num = 10
    val formattedString = """
        var a = 6
        var b = "Kotlin"
        println(a+num)
    """.trimIndent()

    println(formattedString)

}