package com.rideshare.api.controller

import com.rideshare.api.service.TripService
import com.rideshare.common.models.Trip
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/trips")
class TripController(private val tripService: TripService) {

    @PostMapping("/start")
    suspend fun startTrip(@RequestBody tripRequest: Trip): ResponseEntity<Trip> {
        val trip = tripService.startTrip(tripRequest)
        return ResponseEntity.ok(trip)
    }

    @PostMapping("/end")
    suspend fun endTrip(@RequestBody trip: Trip): ResponseEntity<Trip> {
        val endedTrip = tripService.endTrip(trip)
        return ResponseEntity.ok(endedTrip)
    }

    @GetMapping("/history/{userId}")
    suspend fun getHistory(@PathVariable userId: Long): ResponseEntity<List<Trip>> {
        val history = tripService.getTripHistory(userId)
        return ResponseEntity.ok(history)
    }
}