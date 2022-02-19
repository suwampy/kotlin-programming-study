package com.chap02.section2

/**
 * 정수 자료형
 * 코틀린의 정수 자료형은 부호가 있는 것과 부호가 없는 것으로 나뉜다
 * */
fun main() {
    val num05 = 127 // int형으로 추론
    val num06 = -32323 // int형으로 추론
    val num07 = 2312312312 // int형으로 추론
    val num08 = 9223372036854775807 // Long형으로 추론

    // 보통 숫자값은 int형으로 추론되기 때문에 만일 좀 더 작은 범위의 정수 자료형인
    // Byte형이나 Short 형을 사용하기 위해서는 직접 자료형을 명시해야 함
    val exp08 : Byte = 127
    val exp09 = 32667 // 명시적으로 자료형을 지정하지 않으면 Short형 범위의 값도 int형으로 추론
    val exp10 : Short = 32667
}