package com.rideshare.api.controller

import com.rideshare.api.dto.UserDto
import com.rideshare.api.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @PostMapping
    suspend fun registerUser(@RequestBody user: UserDto): ResponseEntity<UserDto> {
        val createdUser = userService.registerUser(user)
        return ResponseEntity.ok(createdUser)
    }

    @GetMapping("/{id}")
    suspend fun getUser(@PathVariable id: Long): ResponseEntity<UserDto> {
        val user = userService.getUser(id)
        return ResponseEntity.ok(user)
    }
}