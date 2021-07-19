package com.google.shinyay

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.shinyay.entity.Book
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
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
@AutoConfigureMockMvc
class ControllerTestWithMock(@Autowired val mockMvc: MockMvc) {

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

    @Test
    fun bookRegistrationThroughAllLayers() {
        val testBook = Book(title = "Testing", author = "shinyay", price = 1000)

        mockMvc.perform(post("/book")
            .contentType(MediaType.APPLICATION_JSON)
            .content(ObjectMapper().writeValueAsString(testBook))
        )
            .andExpect(status().isOk)
    }
}