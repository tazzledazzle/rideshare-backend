package com.rideshare.matching.repository;

import com.rideshare.common.models.Driver;
import com.rideshare.common.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    @Query("SELECT d FROM Driver d WHERE function('distance', d.location.latitude, d.location.longitude, :lat, :lon) < :distance")
    List<Driver> findNearestDrivers(@Param("lat") double lat,
                                    @Param("lon") double lon,
                                    @Param("distance") double distance);

    List<Driver> findAllByIsActiveTrue();
}