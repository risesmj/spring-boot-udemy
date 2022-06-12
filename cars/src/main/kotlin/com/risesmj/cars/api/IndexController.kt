package com.risesmj.cars.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class IndexController {

    @GetMapping
    fun root(): String{
        return "API Cars"
    }
}