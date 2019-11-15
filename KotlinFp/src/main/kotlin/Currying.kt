package com.demo.learnKt

fun sum(x: Int) : (Int) -> Int{
    return { y: Int ->
        x + y
    }
}

fun sum1(x: Int, y: Int) : Int{
    return x + y
}
