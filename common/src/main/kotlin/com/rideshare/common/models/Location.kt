package com.rideshare.common.models

import jakarta.persistence.Embeddable

@Embeddable
data class Location(
    @JvmField
    val latitude: Double,
    @JvmField
    val longitude: Double
) {


    override fun toString(): String {
        return "Location(latitude=$latitude, longitude=$longitude)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Location) return false

        if (latitude != other.latitude) return false
        if (longitude != other.longitude) return false

        return true
    }

    override fun hashCode(): Int {
        var result = latitude.hashCode()
        result = 31 * result + longitude.hashCode()
        return result
    }
    fun getLatitude(): Double {
        return latitude
    }
    fun getLongitude(): Double {
        return longitude
    }
}