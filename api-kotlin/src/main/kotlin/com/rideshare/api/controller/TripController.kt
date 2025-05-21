package com.rideshare.api.controller

import com.rideshare.api.dto.TripDto
import com.rideshare.api.service.TripService
import com.rideshare.common.models.Trip
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/trips")
class TripController(private val tripService: TripService) {

    @PostMapping("/start")
    suspend fun startTrip(@RequestBody tripRequest: TripDto): ResponseEntity<TripDto> {
        val trip = tripService.startTrip(tripRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(trip)
    }

    @PostMapping("/end")
    suspend fun endTrip(@RequestBody trip: Trip): ResponseEntity<TripDto?> {
        val endedTrip = tripService.endTrip(trip)
        return ResponseEntity.status(HttpStatus.OK).body(endedTrip)
    }

    @GetMapping("/history/{userId}")
    suspend fun getHistory(@PathVariable userId: Long): ResponseEntity<List<TripDto>> {
        val history = tripService.getTripHistory(userId)
        return ResponseEntity.ok(history)
    }
}