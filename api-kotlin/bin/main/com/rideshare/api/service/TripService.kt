package com.rideshare.api.service

import com.rideshare.common.models.Trip
import org.springframework.stereotype.Service
import com.rideshare.api.repository.TripRepository
@Service
class TripService(
    private val tripRepository: TripRepository
) {

    suspend fun startTrip(dto: TripDto): Trip {
        val saved = tripRepository.save(dto.toEntity())
        return tripRequest
    }

    suspend fun endTrip(trip: Trip): Trip {
        // TODO: update trip endTime
        return trip
    }

    suspend fun getTripHistory(userId: Long): List<Trip> {
        // TODO: query trip history
        return emptyList()
    }
}