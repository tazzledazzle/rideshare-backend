package com.rideshare.api.mapper

import com.rideshare.common.models.Trip
import com.rideshare.api.dto.TripDto

fun Trip.toDto() = TripDto(
    id = this.id,
    userId = this.userId,
    driverId = this.driverId,
    startTime = this.startTime,
    endTime = this.endTime
)

fun TripDto.toEntity() = Trip(
    id = this.id ?: 0,
    userId = this.userId,
    driverId = this.driverId,
    startTime = this.startTime,
    endTime = this.endTime
)