package com.rideshare.matching.service;

import com.rideshare.common.Config;
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
        // Example pseudo-implementation:
        // Attempt to retrieve driver IDs from Redis geospatial index
        // Fallback to querying the repository if cache miss
        return driverRepository.findNearestDrivers(riderLocation, Config.MAX_MATCH_DISTANCE);
    }

    /**
     * Refreshes driver locations in Redis cache at fixed intervals.
     */
    @Scheduled(fixedRateString = "${matching.refresh.rate:5000}")
    public void refreshDriverLocations() {
        List<Driver> drivers = driverRepository.findAllActiveDrivers();
        drivers.forEach(driver -> {
            String key = Config.REDIS_GEO_KEY;
            redisTemplate.opsForGeo().add(key, driver.getLocation(), driver.getId());
        });
    }
}