package sample

import com.demo.learnKt.Book

fun foo(books: List<Book>?) : Book?{
    val size = books?.size ?: 0
    return if (size >  5){
        books?.get(5)
    }else {
        books?.firstOrNull()
    }
}

fun foo1(books: List<Book>?) : Book?{
    return if (books != null){
        if (books.size > 5){
            books[5]
        }else{
            books.firstOrNull()
        }
    }else{
        null
    }
}

fun foo2(books: List<Book>?) : Book?{
    books ?: return null
    return if (books.size > 5){
        books[5]
    }else{
        books.firstOrNull()
    }
}
