// matching-engine-java/src/main/java/com/rideshare/matching/repository/DriverRepository.java
package com.rideshare.matching.repository;

import com.rideshare.common.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    /**
     * Finds drivers within the specified distance (in meters) of the given coordinates.
     */
    @Query("SELECT d FROM Driver d " +
            "WHERE function('distance', d.location.latitude, d.location.longitude, :lat, :lon) < :distance")
    List<Driver> findNearestDrivers(
            @Param("lat") double latitude,
            @Param("lon") double longitude,
            @Param("distance") double distance
    );

    /**
     * Returns all active drivers.
     */
    List<Driver> findAllByIsActiveTrue();
}