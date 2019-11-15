package com.demo.learnKt.sotre

import com.demo.learnKt.CreateCard
import kotlin.random.Random

/**
 * 费用
 * [id] 唯一标识符，太懒了，用随机数表示
 */
data class Charge(
    val createCard: CreateCard,
    val price: Int,
    val id: Int = Random.nextInt()){
    companion object
}


fun Charge.Companion.monoid(createCard: CreateCard) = ChargeMonoid(createCard)