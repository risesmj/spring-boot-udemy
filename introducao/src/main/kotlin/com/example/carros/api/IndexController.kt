package com.example.carros.api

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class IndexController {

    @GetMapping
    fun get(): String{
        return "Get Spring Boot"
    }

    @GetMapping("login")
    fun login(@RequestParam("login") user: String,
              @RequestParam("password") password: String): String{
        return "Query Params $user and $password"

    }

    @GetMapping("login/{login}/password/{password}")
    fun login2(
        @PathVariable("login") user: String,
        @PathVariable("password") password: String): String
    {
        return "Path Params $user and $password"
    }

    @PostMapping
    fun login3(
        @RequestParam("login") user: String,
        @RequestParam("password") password: String
    ): String{
        return "Post login"
    }

}