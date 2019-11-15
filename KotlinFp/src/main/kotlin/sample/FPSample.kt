package sample

import com.demo.learnKt.Book
import com.demo.learnKt.Group

fun fooIn(func: () -> Unit){
    println("foo")
    func()
}

fun fooOut() : () -> Unit{
    println("hello")
    return { println(" word!")}
}

inline fun Iterable<Book>.filter(predicate: Function1<Book, Boolean>): List<Book> {
    return filterTo(ArrayList<Book>(), predicate)
}

inline fun Collection<Book>.filterTo(destination: MutableCollection<Book>, predicate:Function1<Book, Boolean>): MutableCollection<Book> {
    for (element in this) {
        val isAdd = predicate.invoke(element)
        if (isAdd) destination.add(element)
    }
    return destination
}


fun groupBooks(books: List<Book>){
    val groupBooks = mutableMapOf<Group?, MutableList<Book>>()
    for (book in books){
        if (groupBooks.containsKey(book.group)){
            val subBooks = groupBooks[book.group] ?: mutableListOf()
            subBooks.add(book)
        }else{
            val subBooks = mutableListOf<Book>()
            subBooks.add(book)
            groupBooks[book.group] = subBooks
        }
    }

    for (entry in groupBooks){
        println(entry.key)
        println(entry.value.joinToString(separator = "") { "$it\n" })
        println("——————————————————————————————————————————————————————————")
    }
}

fun groupBooksFp(books: List<Book>){
    books.groupBy { it.group }.forEach { (key, value) ->
        println(key)
        println(value.joinToString(separator = "") { "$it\n" })
        println("——————————————————————————————————————————————————————————")
    }
}

fun getTechnologyBookListFp(books: List<Book>) =
    books.filter { it.group == Group.Technology }.map { it.name }

fun getTechnologyBookList(books: List<Book>) : List<String>{
    val result = mutableListOf<String>()
    for (book in books){
        if (book.group == Group.Technology){
            result.add(book.name)
        }
    }
    return result
}