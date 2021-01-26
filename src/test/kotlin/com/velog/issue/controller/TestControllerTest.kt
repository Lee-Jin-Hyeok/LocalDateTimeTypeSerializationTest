package com.velog.issue.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.velog.issue.controller.dto.TestRequestBody
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import java.time.LocalDateTime
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
internal class TestControllerTest(
    private val mockMvc: MockMvc,
    private val objectMapper: ObjectMapper,
) {

    @Test
    fun `이름 아직 못 정함`() {
        val testRequestBody = TestRequestBody(
            apple = 1,
            banana = "1",
            orange = true,
            time = LocalDateTime.of(2021, 1, 26, 0, 0, 0),
        )
        val content = objectMapper.writeValueAsString(testRequestBody)

        mockMvc.perform(post("/test")
            .content(content)
            .contentType(MediaType.APPLICATION_JSON)
            .characterEncoding("UTF-8"))
            .andExpect(status().isOk)
            .andDo(print())
    }
}