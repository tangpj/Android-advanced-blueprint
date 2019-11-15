@file:Suppress("DuplicatedCode")

package com.demo.learnKt.sotre

import arrow.core.Option
import arrow.core.toOption
import com.demo.learnKt.Book
import com.demo.learnKt.CreateCard
import com.demo.learnKt.initBookCollection


fun main() {
    val (books1, charge1) =
        RefactoringBookStore().buyBooks(CreateCard(123), 1, 3, 5, 10, 20, 30)
    printBuyBooks(books1, charge1)


    println("——————————————————————————————————————————————————\n")

    val (books2, charge2) =
        RefactoringBookStore().buyBooks(CreateCard(111, 120), 7, 2, 8)
    printBuyBooks(books2, charge2)

    println("——————————————————————————————————————————————————\n")


    val cc = CreateCard(12423)
    val (b1, c1) = RefactoringBookStore().buyBooks(cc, 1, 2)
    val (b2, c2) = RefactoringBookStore().buyBooks(cc, 4, 5)
    val (b3, c3) = RefactoringBookStore().buyBooks(cc, 6, 7)

    val books = listOf(b1, b2, b3).flatten()

    printBuyBooks(books, Charge(c1.createCard, c1.price + c2.price + c3.price))

}

fun printBuyBooks(books: List<Book>, charge: Charge){

    val buyBookName = books.map { it.name }
    println("希望购买书本名字： $buyBookName")
    if (charge.createCard.amount >= charge.price){
        val cc = charge.createCard.charge(charge.price)
        println("支付成功，支付金额 = ${charge.price}; 剩余额度 = ${cc.amount}")
    }else{
        println("额度不足，需要支付金额 = ${charge.price}; 可用额度 = ${charge.createCard.amount}")
    }
}

/**
 * 第一次重构BookStore
 */
class RefactoringBookStore{

    private val bookCollection = initBookCollection()

    /**
     * bookId可以传入多个
     */
    fun buyBooks(cc: CreateCard, vararg bookIds: Int) : Pair<List<Book>, Charge>{
        val purchases = bookIds
            .map { buyABook(cc, it).orNull() }
            .filterNotNull()
        val (books, charges) = purchases.unzip()
        //传入的createCard是同一个，所以reduce操作的时候不用判断createCard是否一致
        val totalCharge = charges.reduce {
                acc, charge -> Charge(acc.createCard, acc.price + charge.price) }
        return books to totalCharge
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun buyABook(cc: CreateCard, bookId: Int) : Option<Pair<Book, Charge>> {
        val book = bookCollection[bookId]
        return book.toOption().map { Pair(it, Charge(cc, it.price)) }
    }
}
