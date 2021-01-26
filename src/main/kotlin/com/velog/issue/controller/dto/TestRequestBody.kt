package com.velog.issue.controller.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class TestRequestBody(
    val apple: Int,
    val banana: String,
    val orange: Boolean,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val time: LocalDateTime,
)