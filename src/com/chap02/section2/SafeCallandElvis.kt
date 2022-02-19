package com.chap02.section2

fun main() {
    // 세이프 콜과 엘비스 연산자를 활용해 null을 허용한 변수 더 안전하게 사용하기
    // 세이프콜 : ?.
    // 엘비스(Elvis) 연산자 (?:) : 변수가 null인지 아닌지 검사하여 null이 아니라면 왼쪽 식 실행, null이 아니라면 오른쪽 식 실행
    //
    var str1 : String? = "Hello Kotlin"
    str1 = null
    println("str1: &str1 length: ${str1?.length ?: -1}") // 세이프 콜과 엘비스 연산자 활용
    // str1?.length -> str1이 null이 아닌 경우 length, null인 경우 null 반환
    // ?; -1  -> null이 아니면 왼쪽 값(str1?.length 을, null인 경우 오른쪽 값(-1) 반환
}