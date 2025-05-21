package com.rideshare.api.dto

import java.time.LocalDateTime

data class TripDto(
    val id: Long? = null,
    val userId: Long,
    val driverId: Long,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime? = null
)