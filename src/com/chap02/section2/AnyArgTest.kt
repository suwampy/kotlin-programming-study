package com.chap02.section2

fun main() {
    checkArg("Hello")
    checkArg(5)
}

fun checkArg(x: Any) {
    if (x is String) {
        println("x is String : $x")
    }

    if (x is Int) {
        println("x is Int: $x")
    }
}