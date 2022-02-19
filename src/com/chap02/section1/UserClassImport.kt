package com.chap02.section1

import com.example.edu.Person as User

fun main() {
    val user1 = User("Kildong", 30)
    val user2 = Person("A123", "Kildong")

    println(user1.name)
    println(user1.age)
}

class Person(val id: String, val name: String) {

}