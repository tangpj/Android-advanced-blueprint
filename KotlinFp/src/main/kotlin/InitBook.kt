package com.demo.learnKt

//省略库存，假设集合中存在的书是无限库存的。图书编码简化为int值
fun initBookCollection() = mapOf(
    1 to Book("Kotlin", "小明", 55, Group.Technology),
    2 to Book("中国民俗", "小黄", 25, Group.Humanities),
    3 to Book("娱乐杂志", "小红", 19, Group.Magazine),
    4 to Book("灌篮", "小张", 20, Group.Magazine),
    5 to Book("资本论", "马克思", 50, Group.Political),
    6 to Book("Java", "小张", 30, Group.Technology),
    7 to Book("Scala", "小明", 75, Group.Technology),
    8 to Book("月亮与六便士", "毛姆", 25, Group.Fiction),
    9 to Book("追风筝的人", "卡勒德", 30, Group.Fiction),
    10 to Book("文明的冲突与世界秩序的重建", "塞缪尔·亨廷顿", 24, Group.Political),
    11 to Book("人类简史", "尤瓦尔•赫拉利", 40, Group.Humanities)
)

fun initBookList() = listOf(
    Book("Kotlin", "小明", 55, Group.Technology),
    Book("中国民俗", "小黄", 25, Group.Humanities),
    Book("娱乐杂志", "小红", 19, Group.Magazine),
    Book("灌篮", "小张", 20, Group.Magazine),
    Book("资本论", "马克思", 50, Group.Political),
    Book("Java", "小张", 30, Group.Technology),
    Book("Scala", "小明", 75, Group.Technology),
    Book("月亮与六便士", "毛姆", 25, Group.Fiction),
    Book("追风筝的人", "卡勒德", 30, Group.Fiction),
    Book("文明的冲突与世界秩序的重建", "塞缪尔·亨廷顿", 24, Group.Political),
    Book("人类简史", "尤瓦尔•赫拉利", 40, Group.Humanities)
)

