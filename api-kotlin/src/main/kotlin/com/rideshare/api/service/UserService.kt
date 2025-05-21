package com.rideshare.api.service

import com.rideshare.api.dto.UserDto
import com.rideshare.api.mapper.toDto
import com.rideshare.api.mapper.toEntity
import com.rideshare.api.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class UserService(
    private val userRepository: UserRepository
) {

    @Transactional
    open suspend fun registerUser(dto: UserDto): UserDto {
        val entity = userRepository.save(dto.toEntity())
        return entity.toDto()
    }

    suspend fun getUser(id: Long): UserDto {
        var user = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }!!
        return user.toDto()
    }
}