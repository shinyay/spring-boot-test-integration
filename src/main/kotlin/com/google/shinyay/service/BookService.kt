package com.google.shinyay.service

import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookDaoRepository
import org.springframework.stereotype.Service

@Service
class BookService(val repository: BookDaoRepository) {

    fun displayAllBooks(): MutableList<Book> {
        return repository.findAll()
    }

    fun registerBook(book: Book): Book {
        return repository.save(book)
    }

    fun countTotalFee(): Int {
        val result = repository.findAll()
        var totalFee: Int = 0

        result.forEach { book ->
            totalFee = (totalFee + book.price).toInt()
        }
        return totalFee
    }
}