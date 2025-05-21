package com.rideshare.common.models

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "trips")
data class Trip(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val userId: Long,
    val driverId: Long,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime? = null
)