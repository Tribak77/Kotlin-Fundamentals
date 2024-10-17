package com.example.myapplication

fun main() {
    val treatFunction = trickOrTreat(false){
            extra -> "You got $extra extra treats!"
    }
    val trickFunction = trickOrTreat(true){
            extra -> "You have 0 extra treats!"
    }

    repeat(5){
        treatFunction()
    }

}

fun trickOrTreat(isTrick: Boolean,  extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat: () -> Unit = {
    println("have a treat")
}