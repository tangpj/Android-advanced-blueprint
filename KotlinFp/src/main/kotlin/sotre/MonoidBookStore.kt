@file:Suppress("DuplicatedCode")

package com.demo.learnKt.sotre

import arrow.core.*
import arrow.core.extensions.list.foldable.foldM
import arrow.core.extensions.list.foldable.foldMap
import arrow.core.extensions.tuple2.applicative.just
import arrow.typeclasses.Monoid
import com.demo.learnKt.Book
import com.demo.learnKt.CreateCard
import com.demo.learnKt.initBookCollection


fun main() {
    val cc = CreateCard(12423)
    val (b1, c1) = MonoidBookStore().buyBooks(cc, 1, 2)
    val (b2, c2) = MonoidBookStore().buyBooks(cc, 4, 5)
    val (b3, c3) = MonoidBookStore().buyBooks(cc, 6, 7)

    val books = listOf(b1, b2, b3).flatten()
    val charge = listOf(c1, c2, c3).foldMap(Charge.monoid(cc),::identity)

    printBuyBooks(books, charge )


    println("\n—————————————————敏捷开发来了———————————————————\n")
    //数据初始化
    val cc2 = CreateCard(124234)
    val (b4, c4) = MonoidBookStore().buyBooks(cc2, 1, 2)
    val (b5, c5) = MonoidBookStore().buyBooks(cc2, 4, 5)
    val (b6, c6) = MonoidBookStore().buyBooks(cc2, 6, 7)

    val cc3 = CreateCard(124234512)
    val (b7, c7) = MonoidBookStore().buyBooks(cc3, 3)

    val cc4 = CreateCard(151212)
    val (b8, c8) = MonoidBookStore().buyBooks(cc4, 8)


    //数据处理
    val monoid3 = monoidTuple3(
        //a monoid
        Charge.monoid(cc2),
        //b monoid
        Charge.monoid(cc3),
        //c monoid
        Charge.monoid(cc4))
    val result =  listOf(c6, c7 ,c8).foldMap(monoid3){
        Tuple3(it, it, it)
    }

    println("\n—————————————————第一张信用卡———————————————————")
    //result.a -> monoid a收集的数据
    printBuyBooks(listOf(b4, b5, b6).flatten(), result.a)

    println("\n—————————————————第二张信用卡———————————————————")
    //result.b -> monoid b收集的数据
    printBuyBooks(b7 , result.b)

    println("\n—————————————————第二张信用卡———————————————————")
    //result.b -> monoid b收集的数据
    printBuyBooks(b8, result.c)
}

class MonoidBookStore {

    private val bookCollection = initBookCollection()

    /**
     * bookId可以传入多个
     */
    fun buyBooks(cc: CreateCard, vararg bookIds: Int) : Pair<List<Book>, Charge>{
        val purchases = bookIds
            .map { buyABook(cc, it).orNull() }
            .filterNotNull()
        val (books, charges) = purchases.unzip()

        //使用ChargeMonoid折叠列表
        val totalCharge =  charges.foldMap(Charge.monoid(cc), ::identity)
        return books to totalCharge
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun buyABook(cc: CreateCard, bookId: Int) : Option<Pair<Book, Charge>> {
        val book = bookCollection[bookId]
        return book.toOption().map { Pair(it, Charge(cc, it.price)) }
    }
}

/**
 * 不用理解源码
 * 只需要明白个函数的作用值组合Monoid就行了
 */
fun <A, B, C> monoidTuple3(MA: Monoid<A>, MB: Monoid<B>, MC: Monoid<C>): Monoid<Tuple3<A, B, C>> =
    object: Monoid<Tuple3<A, B, C>> {

        override fun Tuple3<A, B, C>.combine(y: Tuple3<A, B, C>): Tuple3<A, B, C> {
            val (xa, xb, xc) = this
            val (ya, yb, yc) = y
            return Tuple3(MA.run { xa.combine(ya) }, MB.run { xb.combine(yb) }, MC.run { xc.combine(yc) })
        }

        override fun empty(): Tuple3<A, B, C> = Tuple3(MA.empty(), MB.empty(), MC.empty())
    }




