package com.example.myapplication

//fun main() {
//    var number: Int? = 10
//    println(number)
//
//    number = null
//    println(number)
//}

//fun main() {
//    var favoriteActor: String? = null
//    println(favoriteActor?.length)
//}

//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor!!.length)
//}

//fun main() {
//    var favoriteActor: String? = null
//
//    val lengthOfName = if (favoriteActor != null) {
//        favoriteActor.length
//    } else {
//        0
//    }
//
//    println("The number of characters in your favorite actor's name is $lengthOfName.")
//}

fun main() {
    var favoriteActor: String? = null

    val lengthOfName = favoriteActor?.length ?: 0

    println("The number of characters in your favorite actor's name is $lengthOfName.")
}