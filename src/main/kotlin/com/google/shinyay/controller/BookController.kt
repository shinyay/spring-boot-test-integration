package com.google.shinyay.controller

import com.google.shinyay.entity.Book
import com.google.shinyay.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(val service: BookService) {

    @GetMapping("/book")
    fun displayBook(): MutableList<Book> {
        return service.displayAllBooks()
    }

    @PostMapping("/book")
    fun registerBook(@RequestBody book:Book): Book {
        return service.registerBook(book)
    }
}