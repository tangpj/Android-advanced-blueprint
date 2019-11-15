package com.demo.learnKt

/**
 * [amount] 剩余额度，懒，总额度不写了
 */
data class CreateCard(val id: Int,val amount: Int = 500){

    fun charge(price: Int) : CreateCard{
        println("pay $price yuan")
        return copy(amount = amount - price)
    }
}