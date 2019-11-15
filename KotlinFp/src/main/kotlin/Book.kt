package com.demo.learnKt

data class Book(
    val name: String,
    val author: String,
    //单位元，假设只能标价整数
    val price: Int,
    val group: Group?)


enum class Group{
    //科技
    Technology,
    //人文
    Humanities,
    //杂志
    Magazine,
    //政治
    Political,
    //小说
    Fiction
}
