package com.google.shinyay

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.shinyay.entity.Book
import com.google.shinyay.repository.BookDaoRepository
import com.google.shinyay.service.BookService
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureMockMvc
class ControllerTestWithMock(@Autowired val mockMvc: MockMvc) {

    @Autowired
    lateinit var repository: BookDaoRepository

    @Autowired
    lateinit var service: BookService

    @Test
    fun helloShouldReturnDefaultMessage() {
        mockMvc.perform(get("/hello"))
            .andDo(print())
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Hello")))
    }

    @Test
    fun greetingShouldBeOk() {
        mockMvc.perform(get("/greeting"))
            .andDo(print())
            .andExpect(status().isOk)
    }

    @BeforeAll
    fun prepareData() {
        val testBook = mutableListOf<Book>(
            Book(title = "Testing", author = "shinyay", price = 1000),
            Book(title = "Query", author = "shinyay", price = 1010),
            Book(title = "Java", author = "shinyay", price = 500),
            Book(title = "Kotlin", author = "shinyay", price = 800),
            Book(title = "Spring", author = "shinyay", price = 2000)
        )

        testBook.forEach { book ->
            mockMvc.perform(
                post("/book")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(ObjectMapper().writeValueAsString(book))
            )
        }
    }

    @Test
    fun bookRegistrationThroughAllLayersShouldReturnBook() {

        val result = repository.findAllByAuthorOrderByPrice("shinyay").get(0)
        assertThat(result.title).isEqualTo("Java")
    }

    @Test
    fun bookQueryThroughAllLayersShouldReturnBook() {

        val result = repository.findAll().get(1)
        assertThat(result.title).isEqualTo("Query")
    }

    @Test
    fun totalFeeThroughServiceLayersShouldSumPrices() {

        val result = service.countTotalFee()
        assertThat(result).isEqualTo(5310)
    }
}