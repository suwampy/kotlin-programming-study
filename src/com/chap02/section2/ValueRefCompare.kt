package com.chap02.section2

fun main() {
    // 자료형 변환
    // - 코틀린에서는 자료형이 다르면 변환 함수를 사용해야 함
    // - 자바와 달리 자료형이 다른 변수에 재할당하면 자동 형 변환이 되지 않고 자료형 불일치 오류가 발생
    val a: Int = 1
    // val b: Double = a // 자료형 불일치 오류 발생
    // val c: Int = 1.1 // 자료형 불일치 오류 발생
    val b: Double = a.toDouble() // 변환 메소드 사용
    val result = 1L + 3 // Long형 + int형 -> 자료형이 표현할 수 있는 범위가 큰 자료형으로 자동 형 변환 하여 연산됨
}

fun compare() {
    // 이중 등호 비교와 삼중 등호 비교 사용하기
    val a: Int =128
    val b = a
    println(a===b) // 자료형이 기본형인 int형이 되어 값이 동일하므로 true

    val c: Int? = a
    val d: Int? = a
    val e: Int? = c
    println(c == d) // 값의 내용만 비교하는 경우 동일하므로 true
    println(c === d) // 값의 내용은 같지만 참조 주소를 비교해 다른 객체(주소 다름)이므로 false
    println(c === e) // 값의 내용도 같고 참조된 객체도 동일(주소 동일)하므로 true
}