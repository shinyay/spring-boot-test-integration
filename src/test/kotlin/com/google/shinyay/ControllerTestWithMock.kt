package com.google.shinyay

import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
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

}