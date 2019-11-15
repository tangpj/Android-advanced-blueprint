package sample

import arrow.core.Option
import arrow.core.getOrElse


fun main(args: Array<String>) {
    fooOption("hello word!!!")
    println("——————————————————————")
    fooOption(null)
}

fun fooOption(str: String?){
    val optionStr = Option.fromNullable(str)
    val printStr = optionStr.getOrElse { "str is null" }
    println(printStr)
    optionStr.exists {
        println("str is not null! str = $it")
        true
    }

}



