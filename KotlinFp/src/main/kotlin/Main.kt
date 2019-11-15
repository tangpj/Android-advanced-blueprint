package com.demo.learnKt

import arrow.core.Option
import sample.*
import kotlin.collections.filter

fun main(args: Array<String>) {

    val books = initBookList()

    println(getTechnologyBookList(books))
    println()
    println("——————————————————————————————————————")
    println()

    println(getTechnologyBookListFp(books))

    println()
    println("——————————————————————————————————————")
    println()

    println(groupBooks(books))

    println()
    println("——————————————————————————————————————")
    println()
    println(groupBooksFp(books))

    books.filter(object : Function1<Book, Boolean>{
        override fun invoke(p1: Book): Boolean {
            return p1.group == Group.Technology
        }

    })

    val s = sum(5)
    println(s(10))
    println(s(20))
    println(s(30))


}

fun printBookOption(book: Option<Book>){
    book.mapNotNull {
        println("book name = ${it.name}, author = ${it.author}")
        it.group
    }
}




