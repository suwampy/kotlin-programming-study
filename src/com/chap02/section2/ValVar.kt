package com.chap02.section2

/**
 * 변수를 선언하는 방법
 * - val : 최초로 지정한 변수의 값으로 초기화하고 더 이상 바꿀 수 없는 읽기 전용 변수가 됨
 * - var : 최초로 지정한 변수의 초깃값이 있더라도 값을 바꿀 수 있음
 * */
fun main() {
    val number = 10 // number 변수는 int형으로 추론
    var language = "Korean" // language 변수는 String으로 추론
    val secondNumber : Int = 20 // secondNumber 변수는 자료형을 int형으로 명시적으로 지정
    language = "English" // var 키워드로 선언한 변수는 값을 다시 할당할 수 있음

    println("number: $number")
    println("language: $language")
    println("secondNumber: $secondNumber")
}