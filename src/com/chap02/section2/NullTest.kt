package com.chap02.section2

fun main() {
    // var str1 : String = "Hello Kotlin"
    // str1 = null // 오류! null을 허용하지 않음
    // println("str1:" $str1)

    // 변수에 null 할당을 허용하려면 자료형 뒤에 물음표(?) 기호를 명시해야 함
    var str1 : String? = "Hello Kotlin"
    str1 = null
    println("str1: &str1")

    // 세이프 콜(?.) : null이 할당되어 있을 가능성이 있는 변수를 검사하여 안전하게 호출하도록 도와주는 기법
    println("str1: $str1 length: ${str1?.length}") // str1을 세이프 콜로 안전하게 호출

    // non-null 단정기호(!!.) : 변수에 할당된 값이 null이 아님을 단정하므로 컴파일러가 null 검사 없이 무시
    // 하지만 실행 중에 NPE를 발생시킨다
    // println("str1: $str1 length : ${str1!!.length}")
}