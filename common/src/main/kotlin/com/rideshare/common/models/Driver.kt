package com.rideshare.common.models

import javax.persistence.*

@Entity
@Table(name = "drivers")
data class Driver(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val isActive: Boolean = true,
    @Embedded
    val location: Location
)