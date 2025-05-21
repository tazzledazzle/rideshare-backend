package com.rideshare.api.repository

import com.rideshare.api.dto.TripDto
import com.rideshare.common.models.Trip
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface TripRepository : JpaRepository<Trip, Long> {
    fun findAllByUserId(userId: Long): List<Trip>
}