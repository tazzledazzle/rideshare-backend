package com.rideshare.common.models

import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.geo.Point


@Entity
@Table(name = "drivers")
data class Driver(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JvmField
    val id: Long = 0,
    @JvmField
    val isActive: Boolean = true,
    @JvmField
    @Embedded
    val location: Location
) {
    fun getId(): Long {
        return id
    }

    fun getLocation(): Point {
        return Point(location.latitude, location.longitude)
    }
}