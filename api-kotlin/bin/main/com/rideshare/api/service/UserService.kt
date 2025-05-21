package com.rideshare.api.service

import com.rideshare.common.models.User
import org.springframework.stereotype.Service

@Service
class UserService {

    suspend fun registerUser(user: User): User {
        // TODO: persist user to DB
        return user
    }

    suspend fun getUser(id: Long): User {
        // TODO: fetch user from DB
        return User(id, "", "")
    }
}