// matching-engine-java/src/main/java/com/rideshare/matching/service/MatchService.java
package com.rideshare.matching.service;

import com.rideshare.common.models.Driver;
import com.rideshare.common.models.Location;
import com.rideshare.common.Config;
import com.rideshare.matching.repository.DriverRepository;
import com.rideshare.matching.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private RedisTemplate<String, Driver> redisTemplate;

    /**
     * Finds matching drivers near the rider's location.
     *
     * @param riderLocation The location of the rider.
     * @return List of available drivers sorted by proximity.
     */
    public List<Driver> findMatchingDrivers(Location riderLocation) {
        // Try Redis geospatial lookup first
        String geoKey = Config.REDIS_GEO_KEY;
        // (Pseudo-code: retrieve by radius around riderLocation)
        // If cache miss, fallback to DB query:
        // List<Driver> cachedDrivers = redisTemplate.opsForGeo().radius(geoKey, riderLocation, Config.MAX_MATCH_DISTANCE);
        return driverRepository.findNearestDrivers(
                riderLocation.latitude,
                riderLocation.longitude,
                Config.MAX_MATCH_DISTANCE
        );
    }

    /**
     * Refreshes driver locations in Redis cache at fixed intervals.
     */
    @Scheduled(fixedRateString = "${matching.refresh.rate:5000}")
    public void refreshDriverLocations() {
        List<Driver> drivers = driverRepository.findAllByIsActiveTrue();
        drivers.forEach(driver -> {
            String key = Config.REDIS_GEO_KEY;
            redisTemplate.opsForGeo()
                    .add(key, driver.getLocation(), driver);
        });
    }
}