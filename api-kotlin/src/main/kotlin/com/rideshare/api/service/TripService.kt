package com.rideshare.api.service

import com.rideshare.api.dto.TripDto
import com.rideshare.api.mapper.toDto
import com.rideshare.api.mapper.toEntity
import com.rideshare.api.repository.TripRepository
import com.rideshare.common.models.Trip
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class TripService(
    private val tripRepository: TripRepository
) {

    @Transactional
    open suspend fun startTrip(dto: TripDto): TripDto {
        val saved = tripRepository.save(dto.toEntity())
        return saved.toDto()
    }

    @Transactional
    open suspend fun endTrip(trip: Trip): TripDto {
        val trip = tripRepository.findById(trip.id ?: throw RuntimeException("Trip not found"))
            .orElseThrow { RuntimeException("Trip not found") }
        val updated = trip.copy(endTime = trip.endTime)

        return tripRepository.save(updated).toDto()
    }

    suspend fun getTripHistory(userId: Long): List<TripDto> {
        return tripRepository.findAllByUserId(userId).map { it.toDto() }
    }
}