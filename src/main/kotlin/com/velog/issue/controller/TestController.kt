package com.velog.issue.controller

import com.velog.issue.controller.dto.TestRequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @PostMapping("/test")
    fun testController(@RequestBody testRequestBody: TestRequestBody) = testRequestBody
}