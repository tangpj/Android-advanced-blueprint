package com.demo.learnKt

import arrow.core.*
import arrow.core.extensions.id.apply.map
import kotlin.or


fun main(args: Array<String>) {
val buyBook1 = BookStore().buyABook1(CreateCard(1), 1)
    if(buyBook1 != null ) {
        println("book name = ${buyBook1.name}, author = ${buyBook1.author}")
        if (buyBook1.group != null){
            println("book group = ${buyBook1.group}")
        }
    }

    println("\n——————————— createCard is null, bookCode 1 ———————————————")

    val bookStoreOption2 = BookStore()
    buyBook2ForStore(bookStoreOption2, null, 1)

    println("\n—————————————————————————— bookCode 1 ————————————————————————————————")

    buyBook2ForStore(bookStoreOption2, CreateCard(1), 1)

    println("\n—————————————————————————— bookCode 20————————————————————————————————")
    buyBook2ForStore(bookStoreOption2, CreateCard(1), 20)

}

fun buyBook2ForStore(store: BookStore, createCard: CreateCard?, bookCode: Int){
    val buyBook2 = store.buyABook2(createCard, bookCode)
    val bookOption = buyBook2.map{
            println("book name = ${it.name}, author = ${it.author}")
            it.group
        }

    println("start buyBook2ForStore")
    bookOption.exists {
        println("book group = $it")
        true
    }

}

class BookStore {
    private val bookCollection = initBookCollection()

    fun buyABook1(cc: CreateCard?, bookCode: Int) : Book?{
        val result = bookCollection[bookCode]
        if (cc != null && result !=  null){
            cc.charge(result.price)
        }
        return result
    }

    fun buyABook2(cc: CreateCard?, bookCode: Int) : Option<Book>{
        val lcOption = cc.toOption()
        val bookOption = bookCollection[bookCode].toOption()
        lcOption.map2(bookOption){
            it.a.charge(it.b.price)
        }
        return bookOption
    }

}

