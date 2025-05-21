package com.rideshare.api.service

import com.rideshare.common.models.Trip
import org.springframework.stereotype.Service

@Service
class TripService {

    suspend fun startTrip(tripRequest: Trip): Trip {
        // TODO: persist new trip
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