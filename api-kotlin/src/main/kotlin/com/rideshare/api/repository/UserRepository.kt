package com.rideshare.api.repository

import com.rideshare.common.models.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun findByEmail(email: String): User
    fun findByName(name: String): User
    override fun findById(id: Long): Optional<User?>
}