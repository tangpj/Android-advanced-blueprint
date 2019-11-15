package com.demo.learnKt.sotre

import arrow.typeclasses.Monoid
import com.demo.learnKt.CreateCard


/**
 * 避免代码过于凌乱加一个演示用的main方法
 */
fun main() {

}

/**
 * 需要传入[CreateCard] 因为同一张信用卡的费用才能做合并处理
 */
class ChargeMonoid(private val cc: CreateCard) : Monoid<Charge>{

    /**
     * 固定的单位元值，id也需要是固定的
     * 因为同一个ChargeMonoid（equals 为 true）的单位元([empty])是相等(equals 为 true）的
     */
    override fun empty(): Charge = Charge(cc, 0, 0)

    /**
     * 只会合并createCard等于[cc]的Charge
     * 不同信用卡的费用无法合并
     */
    override fun Charge.combine(b: Charge): Charge =
        if (cc == b.createCard){
            Charge(cc, b.price + price)
        }else{
            this
        }

}


