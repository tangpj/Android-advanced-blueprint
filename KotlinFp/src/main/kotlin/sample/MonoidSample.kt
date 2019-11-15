package sample

import arrow.core.extensions.IntMonoid
import arrow.core.extensions.list.foldable.foldMap
import arrow.core.extensions.monoid
import arrow.core.identity
import arrow.core.k

fun main() {
    val monoid = Int.monoid()
    val sum = listOf(1, 2, 3, 4, 5).foldMap(monoid, ::identity)
    println("sum = $sum")

    listOf(1, 2, 3, 4, 5).fold(0){acc, i ->
        acc + i
    }

}