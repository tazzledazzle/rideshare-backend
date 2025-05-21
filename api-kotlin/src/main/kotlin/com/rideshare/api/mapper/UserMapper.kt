package com.rideshare.api.mapper

import com.rideshare.api.dto.UserDto
import com.rideshare.common.models.User

fun User.toDto() = UserDto(
    id = this.id,
    name = this.name,
    email = this.email
)

fun UserDto.toEntity() = User(
    id = this.id ?: 0,
    name = this.name,
    email = this.email
)