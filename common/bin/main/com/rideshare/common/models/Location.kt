package com.rideshare.common.models

import javax.persistence.Embeddable

@Embeddable
data class Location(
    val latitude: Double,
    val longitude: Double
)