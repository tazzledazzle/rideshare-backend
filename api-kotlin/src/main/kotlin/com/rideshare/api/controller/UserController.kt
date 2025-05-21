package com.rideshare.api.controller

import com.rideshare.api.service.UserService
import com.rideshare.common.models.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    suspend fun registerUser(@RequestBody user: User): ResponseEntity<User> {
        val createdUser = userService.registerUser(user)
        return ResponseEntity.ok(createdUser)
    }

    @GetMapping("/{id}")
    suspend fun getUser(@PathVariable id: Long): ResponseEntity<User> {
        val user = userService.getUser(id)
        return ResponseEntity.ok(user)
    }
}